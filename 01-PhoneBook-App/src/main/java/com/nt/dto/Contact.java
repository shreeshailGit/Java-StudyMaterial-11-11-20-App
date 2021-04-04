package com.nt.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Contact {

	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private  Long number;
	private Date createdDate;
	private Date updatedDate;
}
