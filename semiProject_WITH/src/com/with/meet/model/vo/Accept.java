package com.with.meet.model.vo;

public class Accept {
	
	private int no;
	private String title;
	private String userName;
	private String check;
	private String yn;
	
	public Accept() {
		// TODO Auto-generated constructor stub
	}

	public Accept(int no, String title, String userName, String check, String yn) {
		super();
		this.no = no;
		this.title = title;
		this.userName = userName;
		this.check = check;
		this.yn = yn;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getYn() {
		return yn;
	}

	public void setYn(String yn) {
		this.yn = yn;
	}

	@Override
	public String toString() {
		return "Accept [no=" + no + ", title=" + title + ", userName=" + userName + ", check=" + check + ", yn=" + yn
				+ "]";
	}
	
	

}
