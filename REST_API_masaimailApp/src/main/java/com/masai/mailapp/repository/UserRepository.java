package com.masai.mailapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.mailapp.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByEmailAndMobileNumber(String email, String mobileNumber);
}
