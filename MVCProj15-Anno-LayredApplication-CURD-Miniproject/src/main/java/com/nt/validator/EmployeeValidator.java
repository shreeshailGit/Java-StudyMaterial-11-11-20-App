package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;

@Component("empValidator")
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		clazz.isAssignableFrom(Employee.class);//useful to check wheather expected command/model is received
		                                        //to validate class or not
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate(-,-)");
		Employee emp = null;
		// type casting of command class obj
		emp = (Employee) target;

		//write form validation logic
		if (emp.getEname() == null || emp.getEname().isEmpty()) {//required rule
			errors.rejectValue("ename", "emp.ename.required");//errors obj holds property name,error msg collected from properties file
		}
		else if (emp.getEname().length() < 5 || emp.getEname().length() > 10) {//length rule
			errors.rejectValue("ename", "emp.ename.length");
		}
     
		if(emp.getJob() == null || emp.getJob().isEmpty()) {//required rule
			errors.rejectValue("job", "emp.job.required");
		}
		else if(emp.getJob().length() <2 || emp.getJob().length() > 9) {//length rule
			errors.rejectValue("job", "emp.job.length");
		}
		
		if(emp.getSal() == null ) {
			errors.rejectValue("sal", "emp.sal.required");//required rule
		}
		else if(emp.getSal() <10000 || emp.getSal() >1000000) {//length rule
			errors.rejectValue("sal", "emp.sal.length");
		}
	}// method

}// class
