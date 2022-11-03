package com.daadestroyer.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daadestroyer.springsecurity.model.CustomUserDetails;
import com.daadestroyer.springsecurity.model.UserModel;
import com.daadestroyer.springsecurity.repo.UserRepo;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = this.userRepo.findByUsername(username);
		CustomUserDetails userDetails = null;
		if (userModel != null) {
			userDetails = new CustomUserDetails();
			userDetails.setUserModel(userModel);
		} else {
			throw new UsernameNotFoundException("User not exist with name : " + username);
		}
		return userDetails;

	}
}
