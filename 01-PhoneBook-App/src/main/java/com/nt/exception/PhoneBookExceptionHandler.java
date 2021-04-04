package com.nt.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PhoneBookExceptionHandler {

	@ExceptionHandler(value = PhoneBookAppException.class)
	public String handleSaveMethod(Model model) {
		model.addAttribute("saveMsg","Save Failed");
		return "error";
	}

	/*@ExceptionHandler(value = ContactNotFoundException.class)
	public String handleDeleteMethod(Model model) {
		model.addAttribute("deleteMsg", "Contact not found for deletion ");
		return "error";
	}*/
	@ExceptionHandler(value = ContactNotFoundException.class)
	public String handleGetContactByIdMethod(Model model) {
		model.addAttribute("getIDMsg", "Contact ID not found");
		return "error_getId";
	}
	
	
}//class
