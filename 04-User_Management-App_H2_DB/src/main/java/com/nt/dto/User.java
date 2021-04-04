package com.nt.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class User implements Serializable {
	private Integer userId;
	private String fname;
	 private String lname;
	 private String userEmail;
	 private String phNo;
	 private Date dob;
	 private String gender;
	 private String status;
	 private Integer countryId;
	  private Integer stateId;
	  private Integer cityId;
	  private Date createdDate;
	  private Date updatedDate;
	  private String pwd;
	  
	  private String resetPasswordToken;
	  private String vflag= "no";
	
}//class

