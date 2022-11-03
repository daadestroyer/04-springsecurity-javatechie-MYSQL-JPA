package com.daadestroyer.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.daadestroyer.springsecurity.repo.UserRepo;
import com.daadestroyer.springsecurity.model.UserModel;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	// add-user-by-admin
	public String addUserByAdmin(UserModel user) {
		this.userRepo.save(user);
		return "User addedd successfully...";
	}
}
