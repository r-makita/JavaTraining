package sht.servlet;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sht.bean.HamburgerBean;
import sht.dao.DAOException;
import sht.dao.HamburgerDAO;


@WebServlet("/HamburgerServlet")
public class HamburgerServlet extends HttpServlet {




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setCharacterEncodingで文字コードを指定しないと文字化けになる
		request.setCharacterEncoding("UTF-8");

		try {
			response.setContentType("text/html; charset=UTF-8");
			//パラメータの解析
			String action = request.getParameter("action");
			//モデルのDAOを生成 インスタンス化
			HamburgerDAO dao = new HamburgerDAO();

			if (action.equals("login")) {

				//request.getParameter("id")とrequest.getParameter("pass")が入力されなかった時
				//getParameter("id")ではなくidにしてしまうと変数をみていることになる
				if( request.getParameter("id") ==null 
						|| request.getParameter("id").length() == 0 
						|| request.getParameter("pass") ==null 
						|| request.getParameter("pass").length() == 0 ) {

					request.setAttribute("message", "IDとパスワードを入力して下さい");
					//転送先（errInput.jsp）の指定
					RequestDispatcher rd = request.getRequestDispatcher("/err.jsp");
					//リクエスト情報とレスポンス情報を転送先へ送る
					//forwardで転送された情報はPOSTリクエストで送信される
					rd.forward(request, response);
					//doGetメソッドを終了する（returnがかかれるとこのメソッドの処理が終わる）
					return;
				}

				//上記のif文で引っかからなかったら
				//idとpassが呼び出される
				String id = request.getParameter("id");
				String pass = request.getParameter("pass");


				//hamburgerの中にDBで取得したユーザ情報が入ってくる
				HamburgerBean hamburger = dao.findUser(id, pass);

				//入力されたけど見つからなかった時
				//HamburgerBeanで作ったgetId()メソッド、getPass()メソッドを呼び出す
				if(hamburger.getId() ==null||hamburger.getPass() ==null){
					request.setAttribute("message", "ユーザー情報が見つかりません");
					RequestDispatcher rd = request.getRequestDispatcher("/err.jsp");
					rd.forward(request, response);
					return;


				}
				//セッション管理を行う
				HttpSession session=request.getSession();
				//ログイン済みの属性を設定する
				session.setAttribute("isLogin","true");
				//hamburgerにidとpassが入っている
				session.setAttribute("userinfo",hamburger);
				//
				gotoPage(request,response,"/Mypage.jsp");	

			}//新規会員登録
			else if(action.equals("add")) {

				//文字数の縛り
				if(request.getParameter("id") ==null 
						|| request.getParameter("id").length() == 0
						|| request.getParameter("pass") ==null 
						|| request.getParameter("pass").length() <= 7 ) {

					request.setAttribute("message", "IDとパスワードを正しく入力してください");
					RequestDispatcher rd = request.getRequestDispatcher("/err.jsp");
					rd.forward(request, response);
					return;
				}

				String Id = request.getParameter("id");
				String Pass = request.getParameter("pass");

				//daoのaddHamburgerメソッドにid, passを渡す
				dao.addHamburger(Id, Pass);

				gotoPage(request,response,"/Tourokukanryo.jsp");

				//会員情報の変更
			}else if (action.equals("update")) {

				if(	request.getParameter("pass") ==null 
						|| request.getParameter("pass").length() <= 7 ) {
					request.setAttribute("message", "パスワードを正しく入力してください");
					RequestDispatcher rd = request.getRequestDispatcher("/err.jsp");
					rd.forward(request, response);
					return;
				}

				//セッション管理を行う
				//false→セッションを新しく作らない
				HttpSession session=request.getSession(false);
				//ログイン済みの属性を設定する
				//セッション情報のuserinfoをキャスト変換してhamに入れる
				HamburgerBean ham = (HamburgerBean)session.getAttribute("userinfo");

				//
				String Pass = request.getParameter("pass");

				dao.updateByPass(Pass,ham);

				request.setAttribute("PAss", ham);

				gotoPage(request,response,"/Login.jsp");


				//会員情報の削除
			}else if (action.equals("delete")) {

				//セッション管理を行う
				//false→セッションを新しく作らない
				HttpSession session=request.getSession(false);
				//ログイン済みの属性を設定する
				//セッション情報のuserinfoをキャスト変換してhamに入れる
				HamburgerBean h = (HamburgerBean)session.getAttribute("userinfo");

				String Ide = h.getId();
				String Pass = h.getPass();
				
				// カート情報の削除
				dao.deleteByDb(Ide);
				// 会員情報の削除
				dao.deleteByIdAndPass(Ide, Pass);
				
				gotoPage(request,response,"/Login.jsp");

				//カートに追加
			} else if (action.equals("addcart")) {
				String shouhin =request.getParameter("shohinName");
				int  kazu = Integer.parseInt(request.getParameter("kosuu"));
				int  value = Integer.parseInt(request.getParameter("nedan"));
				//セッション管理を行う
				HttpSession session=request.getSession();
				HamburgerBean bean =(HamburgerBean) session.getAttribute("userinfo");

				//ユーザーIDを取得
				String Id = bean.getId();

				int sub = kazu*value;
				int sum=0;
				sum += sub;

				int sub1 = kazu*value;

				//個数と商品名と合計をカートjspで表示したいので
				//request.setAttributeする
				//カートに追加した商品名
				request.setAttribute("sina", shouhin);
				//カートに追加した個数
				request.setAttribute("ko", kazu);
				//カートに追加した商品の値段
				request.setAttribute("nedan", value);
				//合計金額
				request.setAttribute("goukei", sum);
				//値段*個数(各金額)
				request.setAttribute("kingaku", sub1);
				//ID
				request.setAttribute("ID", Id);


				//daoのaddCartメソッドにshouhin,kazu,value,sumを渡す
				dao.addCart(shouhin,kazu,value,sum,sub1, Id);

				List<HamburgerBean> list = dao.findShohinAll(Id);


				//ログイン済みの属性を設定する
				session.setAttribute("shohin", list);

				gotoPage(request,response,"/Cart.jsp");

				//CartDBの削除
			}else if (action.equals("dbdelete")) {

				//セッション管理を行う
				//false→セッションを新しく作らない
				HttpSession session=request.getSession(false);
				//ログイン済みの属性を設定する
				//セッション情報のuserinfoをキャスト変換してbeanに入れる
				HamburgerBean bean =(HamburgerBean) session.getAttribute("userinfo");

				//getIdメソッドを呼び出す
				String Id = bean.getId();

				////daoのdeleteByDbメソッドにidを渡す
				dao.deleteByDb(Id);
				
				gotoPage(request,response,"/Mypage.jsp");

			}
			else if(action.equals("cart")) {
				//セッション管理を行う
				HttpSession session=request.getSession();
				HamburgerBean bean =(HamburgerBean) session.getAttribute("userinfo");
				//ユーザーIDを取得
				String Id = bean.getId();
				List<HamburgerBean> list = dao.findShohinAll(Id);


				//ログイン済みの属性を設定する
				session.setAttribute("shohin", list);	

				gotoPage(request,response,"/Cart.jsp");
			}

		}
		catch( SQLIntegrityConstraintViolationException e ) {
			e.printStackTrace();
			request.setAttribute("message", "同じIDが既に登録されています。");
			gotoPage(request,response,"/err.jsp");		
		}
		//入力ミスとかではない内部処理のエラー
		catch( DAOException e ) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request,response,"/err.jsp");			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

	//gotopage転送用のメソッド 
	protected void gotoPage(HttpServletRequest request, 
			HttpServletResponse response,String page) throws ServletException, 	IOException {
		//転送先の設定
		//	page=/************.jspへ
		RequestDispatcher rd =request.getRequestDispatcher(page);
		//転送
		rd.forward(request, response);
	}
}
