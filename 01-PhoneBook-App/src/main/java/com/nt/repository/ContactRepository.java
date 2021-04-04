package com.nt.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Serializable> {

	@Query("FROM  ContactEntity WHERE contactEmail = :email")
	 public ContactEntity findByEmail(String email);
}
