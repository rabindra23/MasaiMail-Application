package com.masai.mailapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Email {

	@Id
	private int eId;
	private String senderName;
	private String subject;
	private String message;
	private Boolean starredMessage;
	@ManyToOne
	private User user;
	
	public Email() {}

	public Email(int eId, String senderName, String subject, String message, Boolean starredMessage, User user) {
		super();
		this.eId = eId;
		this.senderName = senderName;
		this.subject = subject;
		this.message = message;
		this.starredMessage = starredMessage;
		this.user = user;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStarredMessage() {
		return starredMessage;
	}

	public void setStarredMessage(Boolean starredMessage) {
		this.starredMessage = starredMessage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
