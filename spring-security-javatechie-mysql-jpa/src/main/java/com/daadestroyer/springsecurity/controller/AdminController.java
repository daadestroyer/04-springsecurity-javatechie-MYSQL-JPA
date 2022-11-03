package com.daadestroyer.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.daadestroyer.springsecurity.model.UserModel;
import com.daadestroyer.springsecurity.service.UserService;

@RestController
@RequestMapping("/secure-admin")
public class AdminController {

																																																																																																																																																																									
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// http:localhost:8080/secure-admin/add-user-by-admin
	@PostMapping("/add-user-by-admin")
	public String addUserByAdmin(@RequestBody UserModel userModel) {
		String encryptedPswd = this.passwordEncoder.encode(userModel.getPassword());
		userModel.setPassword(encryptedPswd);
		 String message = this.userService.addUserByAdmin(userModel);
		 return message;
	}
	
	
	@GetMapping("/process")
	public String processing() {
		return "admin is processing...";
	}
}
