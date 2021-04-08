package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExcellentPathLabController {

	@GetMapping("/home")
	public String showHomepage() {
		return "homeDef"; //tiles def as lvn name
	}
	
	@GetMapping("/doctor")
	public String showDoctorspage() {
		return "doctorDef"; //tiles def as lvn name
	}
	
	@GetMapping("/address")
	public String showAddresspage() {
		return "addressDef"; //tiles def as lvn name
	}
	
	@GetMapping("/test")
	public String showTestspage() {
		return "testDef"; //tiles def as lvn name
	}
}//class
