package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	/*@RequestMapping("/welcome")
	public void showHome() {
		
	}
	@RequestMapping("/WELCOME")
	public void showResult() {
		
	}*/
	
	/*@RequestMapping(value = {"/welcome","login","home"},method=RequestMethod.GET)
	public void showHome() {
		
	}
	@RequestMapping(value = "/WELCOME",method = RequestMethod.POST)
	public void showResult() {
		
	}*/
	
	/*@RequestMapping
	public String showHomePage1() {
		return "home_page";
	}*/
	/*@RequestMapping(value = "/welcome",method = {RequestMethod.GET,RequestMethod.POST})
	public String showHomePage2() {
		return  "home_page";
	} */
	
	@RequestMapping(value = "/remove")
	public String deleteStudent() {
     System.out.println("MyController.deleteStudent()");
		return "redirect:display";
	}

	
	@RequestMapping(value = "/update")
	public String updateStudent() {
		System.out.println("MyController.updateStudent()");
		return "redirect:display";
	}
	
	@RequestMapping(value = "/insert")
	public String insertStudent() {
		System.out.println("MyController.insertStudent()");
		return "redirect:display";
	}
	
	@RequestMapping(value = "/display")
	public String viewsStudent() {
		System.out.println("MyController.viewsStudent()");
		return "home_page";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class