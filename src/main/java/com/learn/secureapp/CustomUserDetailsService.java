package com.learn.secureapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.secureapp.dao.UserRepository;
import com.learn.secureapp.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		if (user == null) throw new UsernameNotFoundException("User 404");
		
		return new CustomUserDetails(user);
	}

}
