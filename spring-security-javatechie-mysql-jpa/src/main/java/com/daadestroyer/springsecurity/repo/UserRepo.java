package com.daadestroyer.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.daadestroyer.springsecurity.model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {

	
	public UserModel findByUsername(String username);
}
