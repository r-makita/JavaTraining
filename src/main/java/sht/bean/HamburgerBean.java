package sht.bean;

//ユーザー情報の保持クラス

import java.io.Serializable;

public class HamburgerBean implements Serializable {
	//フィールド変数
	private String id;
	private String pass;
	private String shouhin;
	private int kazu;
	private int kingaku;

	//デフォルトコンストラクタ
	public HamburgerBean() {
	}

	public HamburgerBean(String id, String pass) {
		this.id=id;
		this.pass=pass;
	}

	public HamburgerBean(String shouhin, int kazu) {
		this.shouhin=shouhin;
		this.kazu=kazu;
	}

	//表示させたいときにgetを使う
	public String getId() {
		return id;
	}


	public String getPass() {
		return pass;
	}

	public String getShouhin() {
		return shouhin;
	}

	public int getKazu() {
		return kazu;
	}

	public int getKingaku() {
		return kingaku;
	}

	public void setKingaku(int kingaku) {
		this.kingaku = kingaku;
	}
}