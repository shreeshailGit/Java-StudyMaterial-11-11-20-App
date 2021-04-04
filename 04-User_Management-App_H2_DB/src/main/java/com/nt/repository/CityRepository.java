package com.nt.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nt.entity.CityMasterEntity;
@Repository("cityRepository")
public interface CityRepository extends JpaRepository<CityMasterEntity,Serializable> {

	public List<CityMasterEntity> findAllByStateId(Integer stateId);
}
