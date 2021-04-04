package com.nt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
@Table(name = "COUNTRY_MASTER")
@Entity
@Data
public class CountryMasterEntity {
      @Id
	@GeneratedValue
	@Column(name = "COUNTRY_ID")
	private Integer countryId;
	
	@Column(name = "COUNTRY_CODE")
	private String countryCode;
	
	@Column(name = "COUNTRY_NAME")
	private String countryName;
	
	
}//class
