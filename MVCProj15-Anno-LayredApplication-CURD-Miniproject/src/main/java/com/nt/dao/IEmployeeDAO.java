package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {

	public List<EmployeeBO> getAllEmployees();
	public int insertEmployee(EmployeeBO bo);
	public List<Integer> getEmpdeptNos();
	public int deleteEmployee(int id);
	public EmployeeBO getEmpById(int id);
	public int updateEmpById(EmployeeBO bo);
}
