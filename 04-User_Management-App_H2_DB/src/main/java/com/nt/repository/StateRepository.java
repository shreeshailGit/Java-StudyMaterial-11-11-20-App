package com.nt.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nt.entity.StateMasterEntity;
@Repository("stateRepository")
public interface StateRepository extends JpaRepository<StateMasterEntity,Serializable> {

		public List<StateMasterEntity> findAllByCountryId(Integer countryId);
}
