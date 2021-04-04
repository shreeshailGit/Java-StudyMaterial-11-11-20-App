package com.nt.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.mail.SimpleMailMessage;

import com.nt.dto.User;
import com.nt.entity.UserDetailsEntity;

public interface UserService {
     
	    public boolean saveUserAccDetails(User user);
	    
	    public Map<Integer,String> getAllCountry();
	    
	    public Map<Integer,String> getStatesByCountry(Integer countryId);
	    
	    public Map<Integer,String> getCitiesByStates(Integer stateId);
	    
	    public User getUserByPwdAnduserEmail(String tempPwd,String userEmail);
	    
	    public boolean updateUserAccDetails(User user);
	    
	    public User getUserByUseremailAPwd(String userEmail,String pwd);
	    
	  //TODAY  20-March-2021
	    public void updateResetPasswordToken(String token, String userEmail);
	    public User getByResetPasswordToken(String token);
	    public void updatePassword(User user, String newPassword);
}
