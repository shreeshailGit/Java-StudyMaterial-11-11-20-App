package com.nt.controller;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class GetAllCountriesController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
	        Set<String> countriesList=null;
				Locale[] locales=null;
				
				locales= Locale.getAvailableLocales();
				
				countriesList = new TreeSet();
				
				  for(Locale lc:locales) { 					  
					  countriesList.add(lc.getDisplayCountry());			  
				  }
		// create & return MAV Object		
		return new ModelAndView("result1","cntr",countriesList);
	}

}
