package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Student;

@Controller
public class MainController {

	/*@GetMapping("/register")
	public String showHome(@ModelAttribute("stFrm")Student st) {
		System.out.println("MainController.showHome()"+st);
		 st.setSadd("hyd");
		return "student_form";
	}*/
	@GetMapping("/register")
	public String showHome(@ModelAttribute Student student) {
		System.out.println("MainController.showHome()"+student);
		student.setSadd("hyd");
		return "student_form";
	}
	
	/*@PostMapping("/register")
	public String processForm(Map<String,Object> map,@ModelAttribute("stFrm")Student st) {
		 System.out.println("MainController.processForm()"+st);
		return "result";
	}*/
	
	@PostMapping("/register")
	public String processForm(Map<String,Object> map,@ModelAttribute Student student) {
		 System.out.println("MainController.processForm()"+student);
		return "result";
	}
	
	/*@GetMapping("/links")
	public String getlinksData(Map<String,Object> map,
			                   @RequestParam("sno")int no,
			                   @RequestParam("sname")String name) {
		System.out.println("request values::"+no+"   "+name);
								return "show_param";
		
	}*/
	@GetMapping("/links")
	public String getlinksData(Map<String,Object> map,
			                   @RequestParam List sadd,
			                   @RequestParam(required = false) int sno,
			                   @RequestParam(required = false,defaultValue = "anonymous") String sname
			                   ) {
		System.out.println("request values::"+sno+"   "+sname+" "+sadd.get(0)+"..."+sadd.get(1));
								return "show_param";
		
	}
}//class
