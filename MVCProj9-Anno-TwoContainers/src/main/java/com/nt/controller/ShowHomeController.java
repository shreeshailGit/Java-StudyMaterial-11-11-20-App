package com.nt.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.service.IWishMessageService;
import com.nt.service.WishMessageServiceImpl;

@Controller
public class ShowHomeController {
   @Autowired
	private IWishMessageService service;
  	
	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
	public String showHomeController() {
		return "home";
	}
	
	@RequestMapping(value = "/wish",method = RequestMethod.GET)
	public ModelAndView getWishMessage() {		
		//get Wish Message
		String msg=service.getWishMessage();		
		return new ModelAndView("result","wmsg",msg);
	}
	
	@RequestMapping(value = "/country" ,method = RequestMethod.GET)
	public ModelAndView getAllCountries() {
		Locale[] locales=null;
		
		locales= Locale.getAvailableLocales();
		
        // create & return MAV Object		
         return new ModelAndView("country","cntr",locales);
	}
	
	
}//clas
