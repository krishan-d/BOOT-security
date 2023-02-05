package com.learn.secureapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.secureapp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
}
