package com.nt.controller;

import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class GetAllCountriesController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		PrintWriter pw = null;
		//get PrinteWriter
				pw=res.getWriter();
				res.setContentType("text/html");
			
				Locale[] locales=null;
				
				locales= Locale.getAvailableLocales();
				/*
				 * for(Locale lc:locales) { pw.println(lc.getDisplayCountry()+"<br>"); }
				 */
		// create & return MAV Object		
		return new ModelAndView("result1","cntr",locales);
	}

}
