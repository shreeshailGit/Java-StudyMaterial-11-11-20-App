package com.nt.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.service.ILocaleInfoService;

@Controller
public class ShowHomeController {
    @Autowired
	private ILocaleInfoService service;
	
	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String showHomeController() {
		System.out.println("ShowHomeController.showHomeController()->GET mode");
		return "home";
	}
    
   
	@RequestMapping(value = "/countries",method = RequestMethod.GET)
	public String generateMessage(Map<String,Object> map) {
		Set<String> countriesList=null;
		//use service
		countriesList = service.getAllCountries();	
		//adding multiple model attr
		map.put("listInfo", countriesList);
		map.put("operation", "countries"); //we can give multiple model attr data
		map.put("CountriesCount", countriesList.size());
		//adding lvn name
		return "show_results";
	}
	
	
}//class
