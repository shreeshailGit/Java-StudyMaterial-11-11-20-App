package com.nt.service;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class WishMessageServiceImpl implements WishMessageService {

	@Override
	public String generateMessage() {
	 int hour = 0;
	//get System date and time
	 Calendar calendar = Calendar.getInstance();
	 //get current hour of the day
	 hour =calendar.get(Calendar.HOUR_OF_DAY);
	 //generate Wish message
	 if(hour<12) 
		 return "Good Morning..";
	 else if(hour<16)
		 return "Good Afternoon..";
	 else if(hour<20) 
		 return "Good Evening..";
	 else 
		 return "Good Night..";
	 
	}//method
	
	public String[] getAllcountries() {
		Locale[] locales=null;
		locales= Locale.getAvailableLocales();
		for(Locale lc:locales) {
		//	pw.println(lc.getDisplayCountry()+"<br>");
	   }
		//return lc.getDisplayCountry();
		return null;
	}//method
	
	
	
}//class
