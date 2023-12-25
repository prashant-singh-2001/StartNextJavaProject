package com.startnext.bean;

public class AdminBean {
	private String fname=null;
	private String lname=null;
	private String username=null;
	private String password=null;
	private String email=null;
	public AdminBean(String fname, String lname, String username, String password, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "AdminBean [fname=" + fname + ", lname=" + lname + ", username=" + username + ", password=" + password
				+ ", email=" + email + "]";
	}
	
}
