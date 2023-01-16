package com.masai.mailapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.mailapp.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Integer>{

	List<Email> findByStarredMessage(Boolean starredMessage);
}
