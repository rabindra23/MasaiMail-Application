package com.masai.mailapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.mailapp.entity.Email;
import com.masai.mailapp.entity.User;
import com.masai.mailapp.repository.EmailRepository;
import com.masai.mailapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	EmailRepository emailRepository;
	

	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User loginUser(String email, String mobileNumber) {
		if(userRepository.findByEmailAndMobileNumber(email, mobileNumber)==null) {
			return null;
		}
		return userRepository.findByEmailAndMobileNumber(email, mobileNumber);
	}

	@Override
	public List<Email> getAllMails() {
		return emailRepository.findAll();
	}

	@Override
	public List<Email> getStarredMails() {
		List<Email> starredEmails = emailRepository.findByStarredMessage(true);
		return starredEmails;
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

}
