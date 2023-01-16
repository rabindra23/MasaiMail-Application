package com.masai.mailapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.mailapp.entity.Email;
import com.masai.mailapp.entity.User;

@Service
public interface UserService {

	User registerUser(User user);
	User loginUser(String email, String mobileNumber);
	List<Email> getAllMails();
	List<Email> getStarredMails();
	User updateUser(User user);
}
