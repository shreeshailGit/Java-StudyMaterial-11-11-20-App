package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.IWishMsgService;

@Controller
public class HandlerController {

	@Autowired
	private IWishMsgService service;
	
	@GetMapping("/welcome")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/wish")
	public String showWishpage(Map<String,Object> map) {
		String result =null;
		//use service
		result = service.getWishMsg("ATUL");
		map.put("resultMsg",result);
		return "wish";
	}
	
	
	
	
	
}//class
