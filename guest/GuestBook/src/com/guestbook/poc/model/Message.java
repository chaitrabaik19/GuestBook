package com.guestbook.poc.model;

public class Message {

	public String getUser_message() {
		return user_message;
	}

	public void setUser_message(String user_message) {
		this.user_message = user_message;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	private String user_message;
	
	private int message_id;

	private int user_id;
	
	private String message_status;
	
	private String userImage;

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getMessage_status() {
		return message_status;
	}

	public void setMessage_status(String message_status) {
		this.message_status = message_status;
	}
	
	
	
}
