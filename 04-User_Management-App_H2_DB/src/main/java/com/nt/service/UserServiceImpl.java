package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.constants.AppConstants;
import com.nt.dto.User;
import com.nt.entity.CityMasterEntity;
import com.nt.entity.CountryMasterEntity;
import com.nt.entity.StateMasterEntity;
import com.nt.entity.UserDetailsEntity;
import com.nt.repository.CityRepository;
import com.nt.repository.CountryRepository;
import com.nt.repository.StateRepository;
import com.nt.repository.UserRepository;
import com.nt.utils.EmailUtils;
import com.nt.utils.PwdUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CountryRepository countryRepo;
	@Autowired
	private StateRepository stateRepo;
	@Autowired
	private CityRepository cityRepo;
	@Autowired
	private PwdUtils  pwdUtils;
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public boolean saveUserAccDetails(User user) {
		   user.setPwd(pwdUtils.generateRandomPassword(AppConstants.TEMP_PWD_LENGTH));
		   user.setStatus(AppConstants.LOCKED_STR);
		   //create entity object
		    UserDetailsEntity entity = new UserDetailsEntity();
		    //convert dto to bo OR model to entity
		      BeanUtils.copyProperties(user, entity);
		    //use repository
		    UserDetailsEntity userAccDe = userRepo.save(entity);    
		  
		        if(userAccDe.getUserId() != null) {
		        	return emailUtils.sendUserAccUnlockEmail(user);
		        }
		    return  false;
	}

	@Override
	public Map<Integer, String> getAllCountry() {
	   	Map<Integer,String> map = new HashMap<>();
           List<CountryMasterEntity> countries = countryRepo.findAll();
	           countries.forEach(countryEntity->{
        	            map.put(countryEntity.getCountryId(), countryEntity.getCountryName());
	           });
           return map;
	}

	@Override
	public Map<Integer, String> getStatesByCountry(Integer countryId) {
		Map<Integer,String> map = new HashMap<>();
		List<StateMasterEntity> states = stateRepo.findAllByCountryId(countryId);
		   states.forEach(stateEntity->{
			   map.put(stateEntity.getStateId(),stateEntity.getStateName());
		   });
		return map;
	}
	
	@Override
	public Map<Integer, String> getCitiesByStates(Integer stateId) {
		Map<Integer,String> map = new HashMap<>();
		List<CityMasterEntity> cities = cityRepo.findAllByStateId(stateId);
		
		cities.forEach(cityEntity->{
			  map.put(cityEntity.getCityId(), cityEntity.getCityName());
		});
		
		return map;
	}

	@Override
	public User getUserByPwdAnduserEmail(String pwd, String userEmail) {
		UserDetailsEntity entity= userRepo.findByPwdAndUserEmail(pwd, userEmail);
		User user = null;   
		if(entity !=null) {
		      user = new User();
		     BeanUtils.copyProperties(entity, user);
		}
	   return user;
	}

	@Override
	public boolean updateUserAccDetails(User user) {
		     UserDetailsEntity entity = new UserDetailsEntity();
               BeanUtils.copyProperties(user, entity);
		        UserDetailsEntity saveEntity = userRepo.save(entity);
		  return saveEntity != null;
	}
	@Override
	public User getUserByUseremailAPwd(String userEmail,String pwd){
			    UserDetailsEntity entity = userRepo.findByUserEmailAndPwd(userEmail,pwd);
			    User user = null;
			    if(entity !=null) {
				      user = new User();
				     BeanUtils.copyProperties(entity, user);
				}
			   return user;
	}

	@Override
	public void updateResetPasswordToken(String token, String userEmail) {
		       UserDetailsEntity entity = userRepo.findByUserEmail(userEmail);
		       if(entity!=null)
		    	   entity.setResetPasswordToken(token);
		           userRepo.save(entity);
	}

	@Override
	public User getByResetPasswordToken(String token) {
		UserDetailsEntity entity = userRepo.findByResetPasswordToken(token);
		User user = new User();
		BeanUtils.copyProperties(entity, user);
		return  user;
	}
	
	
	@Override
	public void updatePassword(User user, String newPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        
        UserDetailsEntity entity = new UserDetailsEntity();
        BeanUtils.copyProperties(user, entity);
        entity.setPwd(encodedPassword); 
       // customer.setResetPasswordToken(null);
        entity.setResetPasswordToken(null);
         userRepo.save(entity);
	}

	

	
}//class
