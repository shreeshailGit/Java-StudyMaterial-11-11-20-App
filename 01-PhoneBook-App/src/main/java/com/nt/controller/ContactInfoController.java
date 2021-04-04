package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.dto.Contact;
import com.nt.service.ContactServiceImpl;

@Controller
public class ContactInfoController {
     @Autowired
	private ContactServiceImpl service;
	
	 @GetMapping(value = "/allContacts")
	 public String showContactDetails(Map<String,Object> map) {
		 //use service
		 List<Contact> contacts = service.getAllContacts();
		 //keeps value in attribute
		 map.put("contactInfo",contacts);
		 //give lvn view name
		 return "viewContacts";
	 }
	 
     @GetMapping(value = {  "/" , "/addContact"})
	 public String  saveContact(Model model ) {
    	 Contact c = new Contact();
    	 model.addAttribute("contactFrm", c);
   		 return "contact";
	 }
     @PostMapping(value = "/saveContact")
     public String  addContact(@ModelAttribute("contactFrm") Contact dto ,RedirectAttributes redirect ) {
    	     	 //use service
    	     boolean result = service.registerContact(dto);
    	     if(result){
    	    	 redirect.addFlashAttribute("succMsg", " Contact Saved");
    	     }else {
    	    	 redirect.addFlashAttribute("errMsg", "Failed to save Contact");
    	     }
     		  
    	     //return lvn
    	      return "redirect:/addContact";
	 }
     
     @GetMapping(value = "/validateEmail")
     public @ResponseBody String fetchByEmailId(@RequestParam("email")String emailId) {
    	        //use service
    	            return  service.getEmailById(emailId);
     }
	 
}//class
