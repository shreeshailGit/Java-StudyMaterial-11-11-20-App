package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nt.bo.EmployeeBO;

public interface EmployeeRepository extends CrudRepository<EmployeeBO,Integer> {

	@Query("SELECT DISTINCT deptno FROM EmployeeBO WHERE deptno IS NOT NULL") //JPQL/HQL
	public List<Integer> getAlldeptNo();
	
}
