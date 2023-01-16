package com.masai.mailapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.mailapp.entity.Email;
import com.masai.mailapp.repository.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	EmailRepository emailRepository;

	@Override
	public Email sendMail(Email email) {
		return emailRepository.save(email);
	}

	@Override
	public Email starMail(int eId) {
		Email email = emailRepository.findById(eId).get();
		email.setStarredMessage(true);
		return email;
	}

	@Override
	public Boolean deleteMail(int eId) {
		emailRepository.deleteById(eId);
		return true;
	}

}
