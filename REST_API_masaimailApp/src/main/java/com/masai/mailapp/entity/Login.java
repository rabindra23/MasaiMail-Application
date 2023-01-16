package com.masai.mailapp.entity;

public class Login {

	private String email;
	private String mobileNumber;
	
	public Login() {}

	public Login(String email, String mobileNumber) {
		super();
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	
	
}
