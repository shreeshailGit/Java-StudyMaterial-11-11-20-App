package com.nt.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.UserDetailsEntity;

public interface UserRepository  extends JpaRepository<UserDetailsEntity,Serializable>{
   //for update Pwd and Status
	public UserDetailsEntity  findByPwdAndUserEmail(String pwd,String userEmail);
	
	public UserDetailsEntity findByUserEmailAndPwd(String userEmail,String pwd);
	
	
	//TODAY  20-March-2021
	 @Query("SELECT u FROM UserDetailsEntity u WHERE u.userEmail = ?1")
	    public UserDetailsEntity findByUserEmail(String userEmail); 
	     
	    public UserDetailsEntity findByResetPasswordToken(String token);
	
}
