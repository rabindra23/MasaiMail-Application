package com.masai.mailapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.mailapp.entity.User;
import com.masai.mailapp.entity.Email;
import com.masai.mailapp.entity.Login;
import com.masai.mailapp.service.EmailService;
import com.masai.mailapp.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/masaimail")
public class MyController {

	@Autowired
	UserService userService;
	@Autowired
	EmailService emailService;
	
	//Rest API for User Resource
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user){
		User registeredUser = userService.registerUser(user);
		return new ResponseEntity<User>(registeredUser,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody Login login){
		User user = userService.loginUser(login.getEmail(), login.getMobileNumber());
		if(user==null) {
			return new ResponseEntity<User>(user,HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/mail")
	public ResponseEntity<?> getMail(){
		List<Email> emails = userService.getAllMails();
		return ResponseEntity.ok(emails);
	}
	
	@GetMapping("/starred")
	public ResponseEntity<?> getStarredMail(){
		List<Email> emails = userService.getStarredMails();
		return ResponseEntity.ok(emails);
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> updateUser(@RequestBody User user){
		User updateUser = userService.updateUser(user);
		return ResponseEntity.ok(updateUser);
	}
	
	//Rest API for Email Resource
	
	@PostMapping("/mail")
	public ResponseEntity<?> postMail(@RequestBody Email email){
		Email em = emailService.sendMail(email);
		return ResponseEntity.ok(em);
	}
	
	@PostMapping("/starred/{id}")
	public ResponseEntity<?> starEmail(@PathVariable int id){
		Email starMail = emailService.starMail(id);
		return ResponseEntity.ok(starMail);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmail(@PathVariable int id){
		boolean deletedEmail = emailService.deleteMail(id);
		return ResponseEntity.ok(deletedEmail);
	}
	
}
