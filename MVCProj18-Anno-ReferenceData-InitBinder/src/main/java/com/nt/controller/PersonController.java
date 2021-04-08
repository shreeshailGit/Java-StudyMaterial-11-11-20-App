package com.nt.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Person;

@Controller
public class PersonController {

	@GetMapping("/person")
	public  String   showFormPage(@ModelAttribute("perFrm") Person per) {
		//return LVN
		return "person_form";
	}
	
	@PostMapping("/person")
	public String personDetails(Map<String,Object> map,@ModelAttribute("perFrm") Person per) {
		System.out.println("model class obj "+per);
		return "success_form";
	}
	
	//reference data radioButton
	@ModelAttribute("genderList")
	public List<String> populateGender() {
		System.out.println("PersonController.populateGender()");
		List<String> genderList=List.of("female","male");  //java 9 feature.
		return genderList;
	}
	//reference data checkbo
	@ModelAttribute("hobiesList")
	 public List<String> populateHobies(){
		System.out.println("PersonController.populateHobies()");
		 List<String> hobiesList = List.of("reading","roaming","playing","workouts","sleeping");  //java 9 feature.
		 return hobiesList;
	 }
	
	//reference data  selectbutton
	@ModelAttribute("qlfyList")
	public List<String> populateQlfy(){
		System.out.println("PersonController.populateQlfy()");
		List<String> qlfyList = List.of("BE","MCA","B.com","Arts","LLB","M.com");//java 9 feature.
       return qlfyList;
	}
	
	//reference data checkbox
	@ModelAttribute("colorsList")
	public List<String> popluateColors(){
		System.out.println("PersonController.popluateColors()");
		 List<String> colorsList = List.of("red","purple","yellow","white","green");  //java 9 feature.
		 return colorsList;
	}
	
	@InitBinder
	public void myInitbinder(ServletRequestDataBinder binder){
		System.out.println("PersonController.myInitbinder()");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
	}	
	
   	
	
	
	

}//class
