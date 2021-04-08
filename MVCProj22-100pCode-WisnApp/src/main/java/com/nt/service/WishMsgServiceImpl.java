package com.nt.service;
 
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMsgServiceImpl implements IWishMsgService {

	@Override
	public String getWishMsg(String user) {
		LocalDateTime date = LocalDateTime.now();
		//get current hour 
		int hour = date.getHour();
		
		if(hour < 12)
		    return "Good Morning " +user;
		else if(hour <16)
			return "Good Afternoon "+user;
		else if (hour <20)
			 return "Good Evening "+user;
		else 
			return "Good Night "+user;
	}//method

}//class
