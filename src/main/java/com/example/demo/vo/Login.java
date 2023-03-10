package com.example.demo.vo;

//VO 클래스 : VO는 Value Object 줄임말
//VO 클래스에는 필드변수와 getter, setter만 온다.
public class Login {
	
	private String id;
	private String pw;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
