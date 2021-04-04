package com.nt.service;

import java.util.List;

import com.nt.dto.Contact;

public interface ContactService {

	public List<Contact> getAllContacts();
	public boolean registerContact(Contact dto);
    public boolean deleteContact(Integer cid);
    public Contact getContactById(Integer contactId);
    
    public String getEmailById(String email);
    
}
 