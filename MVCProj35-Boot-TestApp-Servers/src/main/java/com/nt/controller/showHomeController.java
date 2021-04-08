package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class showHomeController {

	@GetMapping("/welcome")
	public String showHomePage() {
		return "home";
	}//method
}//class
