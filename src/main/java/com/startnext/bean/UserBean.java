package com.startnext.bean;

public class UserBean {
	private String fname=null;
	private String lname=null;
	private String username=null;
	private String password=null;
	private String mail=null;
	private String start_id=null;
	private String image=null;
	private long contact;
	private int pincode;
	private int id;
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBean(String fname, String lname, String username, String password, String mail, String start_id,
			String image, long contact, int pincode, int id) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.start_id = start_id;
		this.image = image;
		this.contact = contact;
		this.pincode = pincode;
		this.id = id;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getStart_id() {
		return start_id;
	}
	public void setStart_id(String start_id) {
		this.start_id = start_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "UserBean [fname=" + fname + ", lname=" + lname + ", username=" + username + ", password=" + password
				+ ", mail=" + mail + ", start_id=" + start_id + ", image=" + image + ", contact=" + contact
				+ ", pincode=" + pincode + ", id=" + id + "]";
	}
	
}
