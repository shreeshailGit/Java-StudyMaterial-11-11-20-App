package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Entity
@Data
@Table(name = "USER_DTLS")
public class UserDetailsEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "user_id_seq",sequenceName = "USER_DTLS_SEQ",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "user_id_seq",strategy = GenerationType.SEQUENCE)
     @Column(name = "USER_ID")
	private Integer userId;
    
    @Column(name = "FIRST_NAME")
	private String fname;
	
    @Column(name = "LAST_NAME")
    private String lname;
    
    @Column(name = "USER_EMAIL")
	private String userEmail;
    
    @Column(name = "USER_MOBILE")
	private String phNo;
    
    @Column(name = "DOB")
	private Date dob;
    
    @Column(name = "GENDER")
	private String gender;
    
    @Column(name = "ACC_STATUS")
	private String status;
    
    @Column(name = "COUNTRY_ID")
    private Integer countryId;
    
    @Column(name = "STATE_ID")
    private Integer stateId;
    
    @Column(name = "CITY_ID")
    private Integer cityId;
    
    @CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE" , updatable = false)
	private Date createdDate;
    
    @UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE" ,insertable = false)
	private Date updatedDate;
    
    @Column(name = "USER_PWD")
	private String pwd;
    
  //TODAY  20-March-2021
    @Column(name = "reset_password_token")
    private String resetPasswordToken;
	
	
}//class
