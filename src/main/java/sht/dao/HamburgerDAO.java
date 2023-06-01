package sht.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import sht.bean.HamburgerBean;


public class HamburgerDAO {
	//フィールド変数
	//このクラス内であればどこでも使用可能
	private Connection con;

	//findUserはメソッド名
	public HamburgerBean findUser(String id, String pass)throws DAOException{
		if(con==null) {
			getConnection();
		}

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL文の作成
			//USERINFOが存在するかの確認
			String sql = "SELECT * FROM USERINFO WHERE ID = ? AND PASS = ? ";

			// SQL実行準備
			st=con.prepareStatement(sql);

			// 上記のSELECT文の「?」に引数で受け取ったIDとPASSを設定する。
			// プレースホルダと言うよ
			st.setString(1, id);
			st.setString(2, pass);

			// SQL実行
			rs =st.executeQuery();

			//インスタンス化
			HamburgerBean bean = new HamburgerBean();
			// 1レコードずつ取得
			while(rs.next()) {
				//変数名が重複しているためstrIdにする
				String strId = rs.getString("id");
				String strPass = rs.getString("pass");

				//インスタンス化
				//String,Stringのコンストラクタを呼び出しDBから取得した値をHamburgerBeanに設定
				bean = new HamburgerBean(strId, strPass);
			}
			return bean;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}finally {
			try {
				if(st !=null)st.close();
				close();
			}catch(Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");		
			}
		}
	}

	PreparedStatement st = null;

	public int addHamburger(String id,String pass) throws DAOException, SQLIntegrityConstraintViolationException{
		if (con == null) 
			getConnection();

		//新規会員登録
		try {
			String sql = "INSERT INTO USERINFO(id,pass)VALUES(?,?)";
			st=con.prepareStatement(sql);
			st.setString(1,id);
			st.setString(2,pass);

			//操作したレコード数　更新したら+1
			int rows = st.executeUpdate();
			return rows ;

		}catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new SQLIntegrityConstraintViolationException("同じIDが既に登録されています。");
		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}	


	}//会員情報の削除
	public int deleteByIdAndPass(String id, String pass)throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st = null;

		try {
			String sql ="DELETE FROM USERINFO WHERE ID = ? AND PASS = ?";

			st=con.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, pass);
			int rows = st.executeUpdate();
			return rows;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}finally {
			try {
				if(st !=null)st.close();
				close();
			}catch(Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");	
			}
		}
	}

	//カートに追加
	public int addCart(String shouhin,int kazu, int value,int sum,int sub1,String Id) throws DAOException{
		if (con == null) 
			getConnection();
		//実行準備
		PreparedStatement st = null;

		try {
			String sql = "INSERT INTO CART(SHOUHIN,KAZU,ID,SHOUKEI)VALUES(?,?,?,?)";
			st=con.prepareStatement(sql);
			st.setString(1,shouhin);
			st.setInt(2,kazu);
			st.setString(3,Id);
			st.setInt(4,sub1);

			//SQLの実行
			int rows = st.executeUpdate();
			return rows;

			//SQL文に誤りがあった場合（引数が取れていない）
		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	//findUserはメソッド名
	public List<HamburgerBean> findShohinAll(String id)throws DAOException{
		if(con==null) {
			getConnection();
		}

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL文の作成
			//USERINFOが存在するかの確認
			String sql = "SELECT * FROM CART WHERE ID=? ";

			// SQL実行準備
			st=con.prepareStatement(sql);
			
			st.setString(1,id);

			// SQL実行
			rs =st.executeQuery();

			//インスタンス化
			HamburgerBean bean = new HamburgerBean();
			List<HamburgerBean> list = new ArrayList<HamburgerBean>();
			// 1レコードずつ取得
			while(rs.next()) {
				String strShohin = rs.getString("SHOUHIN");
				int intPass = rs.getInt("kazu");
				int intShoukei = rs.getInt("SHOUKEI");

				//インスタンス化
				//String,Stringのコンストラクタを呼び出しDBから取得した値をHamburgerBeanに設定
				bean = new HamburgerBean(strShohin, intPass);
				bean.setKingaku(intShoukei);
				list.add(bean);
			}
			// カート情報を返却する
			return list;

		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");

		}finally {
			try {
				if(st !=null)st.close();
				close();
			}catch(Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");		
			}
		}
	}
	//cartテーブルの対象商品を削除
	public int deleteByDb(String Ide)throws DAOException{
			if(con==null)
				getConnection();

			PreparedStatement st = null;

			try {
				//IDで消す
				String sql ="DELETE FROM cart WHERE ID = ?";

				st=con.prepareStatement(sql);
				st.setString(1, Ide);
				int rows = st.executeUpdate();
				return rows;
			}catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("レコードの操作に失敗しました。");
			}finally {
				try {
					if(st !=null)st.close();
					close();
				}catch(Exception e) {
					throw new DAOException("リソースの開放に失敗しました。");	
				}
			}
		}
	//会員情報の変更
	public int updateByPass(String pass,HamburgerBean bean)throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st = null;

		try { //1つ目の？は入力されたもの、2つ目の？は変更前
			String sql ="UPDATE USERINFO SET PASS=? WHERE PASS = ?";

			st=con.prepareStatement(sql);
			
			//入力されたもの
			st.setString(1, pass);
			//変更前
			st.setString(2,bean.getPass());
			
			int rows = st.executeUpdate();
			return rows;

			

		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}finally {
			try {
				if(st !=null)st.close();
				close();
			}catch(Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");	
			}
		}
	}



	private void getConnection()throws DAOException{
		try {
			//DBへの接続情報
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/hamburger?serverTimezone=UTC&useSSL=false";
			String user = "root";
			String pass = "P@ssw0rd";

			//接続出来たらconに情報が入る
			con = DriverManager.getConnection(url,user,pass);
			//情報が間違っていた時
		}catch(Exception e) {
			throw new DAOException("接続に失敗しました。");
		}
	}
	private void close() throws SQLException{
		if (con != null) {
			con.close();
			con=null;
		}
	}
}
