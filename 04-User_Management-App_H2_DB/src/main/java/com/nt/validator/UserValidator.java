package com.nt.validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.dto.User;
@Component("usrValidator")
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		clazz.isAssignableFrom(User.class);//useful to check wheather expected command/model is received
        //to validate class or not
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = null;
		//type csting
		user = (User)target;
		
		//write form validation logic
				if (user.getUserEmail() == null || user.getUserEmail().isEmpty()) {//required rule
					errors.rejectValue("userEmail", "user.userEmail.required");//errors obj holds property name,error msg collected from properties file
				}
				else if (user.getUserEmail().length() < 3 || user.getUserEmail().length() > 10) {//length rule
					errors.rejectValue("userEmail", "user.userEmail.length");
				}
				
				if(user.getPwd() == null || user.getPwd().isEmpty()) {
					errors.rejectValue("pwd", "user.pwd.required");
				}
				else if(user.getPwd().length() < 6 ||user.getPwd().length()>10 ) {
					errors.rejectValue("pwd", "user.pwd.length");
				}
	}//method

}//class
