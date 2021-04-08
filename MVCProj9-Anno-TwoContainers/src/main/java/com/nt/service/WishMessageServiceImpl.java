package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Service("wishss")
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String getWishMessage() {
		/*	int hour = 0;	
		//get wish Message
		hour = Calendar.HOUR_OF_DAY;
		
		if(hour<12)
			return "good morning";
		else if(hour<4)
			return "good afternoon";
		else if(hour<8)
			return "good evening";
		else
			return "good night";	
	}//method*/
	
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

}
