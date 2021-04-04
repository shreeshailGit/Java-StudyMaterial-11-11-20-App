package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.Contact;
import com.nt.entity.ContactEntity;
import com.nt.exception.ContactNotFoundException;
import com.nt.exception.PhoneBookAppException;
import com.nt.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public List<Contact> getAllContacts() {
					// use repository
			List<ContactEntity> entites = contactRepo.findAll();
			// Java 8 stream API
			return entites.stream().map(entity -> {
				Contact c = new Contact();
				BeanUtils.copyProperties(entity, c);
				return c;
			}).collect(Collectors.toList());
		}// method

	@Override
	public boolean registerContact(Contact dto) {
		boolean isSaved = false;
		try {
			// convert dto to entity
			ContactEntity entity = new ContactEntity();
			BeanUtils.copyProperties(dto, entity);
			ContactEntity saveEntity = contactRepo.save(entity);
			if (saveEntity != null) {
				isSaved = true;
			}
		} // try
		catch (Exception e) {
			throw new PhoneBookAppException("Save Failed");
		}
		return isSaved;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		try {
			if (cid != 0)
				// use dao
				contactRepo.deleteById(cid);
			return true;
		} // try
		catch (Exception e) {
			throw new ContactNotFoundException("Contact not found for deletion");
		} // catch

	}

	@Override
	public Contact getContactById(Integer contactId) {
		try {
			Optional<ContactEntity> findById = contactRepo.findById(contactId);
			if (findById.isPresent()) {
				ContactEntity entity = findById.get();
				Contact c = new Contact();
				BeanUtils.copyProperties(entity, c);
				return c;
			}
		} // try
		catch (Exception e) {
			throw new ContactNotFoundException("Contact Id not found");
		} // catch
		return null;
	}

	@Override
	public String getEmailById(String email) {
		ContactEntity entity = contactRepo.findByEmail(email);
		
		/*if(null !=entity) {
			return "Duplicate";
		}
			return "Unique";*/
		return entity != null ?"Duplicate" : "Unique";
	}

}// class
