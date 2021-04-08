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
	
	//@RequestMapping(value = "/welcome",method = RequestMethod.GET)
	@RequestMapping(value = "/")
    public String showHomeController() {
		System.out.println("ShowHomeController.showHomeController()->GET mode");
		return "home";
	}
    
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String showHomeController1() {
         System.out.println("ShowHomeController.showHomeController1()-->POST mode");
		return "home";
	}
	
	
	@RequestMapping(value = "/languges",method = RequestMethod.GET)
	public String generateLanguages(Model model) {
		Set<String> languageList =null;
		//use service
		languageList = service.getAllLanguages();
		model.addAttribute("listInfo1", languageList);
		model.addAttribute("count", languageList.size());
		return "show_results1";
	}
	
/*	@RequestMapping(value = "/countries",method = RequestMethod.GET)
	public ModelAndView generateMessage() {
		Set<String> countriesList=null;
		//use service
		countriesList = service.getAllCountries();		
		return new ModelAndView("show_results","listInfo",countriesList);
	}*/
	
  /*	@RequestMapping(value = "/countries",method = RequestMethod.GET)
	public ModelAndView generateMessage() {
		Set<String> countriesList=null;
		ModelAndView mav =null;
		//use service
		countriesList = service.getAllCountries();	
		mav = new ModelAndView();
		//adding multiple model attr
		mav.addObject("listInfo", countriesList);
		mav.addObject("operation", "countries"); //we can give multiple model attr data
		mav.addObject("CountriesCount", countriesList.size());
		//adding lvn name
		mav.setViewName("show_results");
		return mav;
	}*/
	
	/*@RequestMapping(value = "/countries",method = RequestMethod.GET)
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
	}*/
	
	/*@RequestMapping(value = "/countries",method = RequestMethod.GET)
	public String generateMessage(ModelMap map) {
		Set<String> countriesList=null;
		//use service
		countriesList = service.getAllCountries();			
		//adding multiple model attr
		map.put("listInfo", countriesList);
		map.put("operation", "countries"); 
		map.put("CountriesCount", countriesList.size());
		//adding lvn name
		return "show_results";
	}*/
	
	/*@RequestMapping(value = "/countries",method = RequestMethod.GET)
	public String generateMessage(Model model) {  //Best
		Set<String> countriesList=null;
		//use service
		countriesList = service.getAllCountries();			
		//adding multiple model attributes
		model.addAttribute("listInfo", countriesList);
		model.addAttribute("operation", "countries"); 
		model.addAttribute("CountriesCount", countriesList.size());
		//adding lvn name
		return "show_results";
	}//method*/
	
	/*@RequestMapping(value = "/countries",method=RequestMethod.GET)
	public void generateMessage(Model model) {
		Set<String> countriesList = null;
		//use service
		countriesList = service.getAllCountries();
		//adding multiple model attributes
		model.addAttribute("listInfo",countriesList);
		model.addAttribute("operation","countries");
		model.addAttribute("CountriesCount", countriesList.size());
	}//method*/
	
	/*@RequestMapping(value = "/countries",method=RequestMethod.GET)
	public void generateMessage(ModelAndView mav) {   //Bad practise not work
	                                          ModelAndView is argument param type
		Set<String> countriesList = null;
		//use service
		countriesList = service.getAllCountries();
		//adding multiple model attributes
		mav.addObject("listInfo",countriesList);
		mav.addObject("operation","countries");
		mav.addObject("CountriesCount", countriesList.size());
		mav.setViewName("show_results");
	}//method  */
	
	/*@RequestMapping(value = "/countries",method=RequestMethod.GET)//Problem signature
	public Map<String,Object> generateMessage() {   //Bad practise bcz we have to create 
		Set<String> countriesList = null;          //map object manually
		Map<String,Object> map = new HashMap();
		//use service
		countriesList = service.getAllCountries();
		//adding multiple model attributes
		map.put("listInfo",countriesList);
		map.put("operation","countries");
		map.put("CountriesCount", countriesList.size());
		return map;
	}//method  */
	
	/*@RequestMapping(value = "/countries/add",method = RequestMethod.GET)
	public String generateMessage(Model model) {  //Best
		Set<String> countriesList=null;
		//use service
		countriesList = service.getAllCountries();			
		//adding multiple model attributes
		model.addAttribute("listInfo", countriesList);
		model.addAttribute("operation", "countries"); 
		model.addAttribute("CountriesCount", countriesList.size());
		//adding lvn name
		return "show_results";
	}//method */
	
	@RequestMapping(value = "/countries",method=RequestMethod.GET)
	public Model generateMessage() {
		Set<String> countriesList = null;
		Model model = null;
		//use service
		countriesList = service.getAllCountries();
		model = new ExtendedModelMap();
		//adding multiple model attributes
		model.addAttribute("listInfo",countriesList);
		model.addAttribute("operation","countries");
		model.addAttribute("CountriesCount", countriesList.size());
		return model;
	}//method  
	
}//class
