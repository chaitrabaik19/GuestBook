package com.guestbook.poc.model;

public class User {

	public int user_id;
	public String user_name;
	public String password;
	public String user_role;
	
	
	public User(int user_id, String user_name, String password, String user_role) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.user_role = user_role;
	}
	
	public User() {
		
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	
	
}
