package com.daadestroyer.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure-global")
public class ApplicationController {

	// localhost:8080/secure-global/process
	@GetMapping("/process")
	public String processing() {
		return "processing...";
	}
}
