package com.nt.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.CountryMasterEntity;
@Repository("countryRepository")
public interface CountryRepository extends JpaRepository<CountryMasterEntity,Serializable> {

}
