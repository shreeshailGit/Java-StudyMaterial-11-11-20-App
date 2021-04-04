package com.nt.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ContactNotFoundException extends RuntimeException {

	public ContactNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	 public ContactNotFoundException(String msg) {
		super(msg);
	}
}//class
