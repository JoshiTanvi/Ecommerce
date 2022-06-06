package com.project.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@RequestMapping("/")
	public String welcome() {
		System.out.println("Hello from the controller");
		return "Welcome to the Ecommerce project";
	}
}
