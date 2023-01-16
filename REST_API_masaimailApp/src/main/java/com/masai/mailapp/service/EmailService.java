package com.masai.mailapp.service;

import org.springframework.stereotype.Service;

import com.masai.mailapp.entity.Email;

@Service
public interface EmailService {

	Email sendMail(Email email);
	Email starMail(int eId);
	Boolean deleteMail(int eId);
}
