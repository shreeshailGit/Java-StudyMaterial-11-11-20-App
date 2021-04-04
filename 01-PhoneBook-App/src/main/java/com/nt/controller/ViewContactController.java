package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.dto.Contact;
import com.nt.service.ContactServiceImpl;

@Controller
public class ViewContactController {
	
	@Autowired
	private ContactServiceImpl service;
	   
	@GetMapping(value = "/edit")               
	 public String  updateContact(@RequestParam("cid") Integer contactId,Model model) {
		   Contact contactById = service.getContactById(contactId);
		   model.addAttribute("contactFrm", contactById);
		     	 return "contact";
	 }
		
	 

	  @GetMapping(value = "/delete")
	 public String  removeContact(@RequestParam("cid") Integer contactId) {
		 //use service
		 	boolean isdeleted = service.deleteContact(contactId);
		 //add results in flash attribute
		 	if(isdeleted) {
		 		 		 		return "redirect:/allContacts";
		 	}
		 			 return null;
	 }
	
}//class
