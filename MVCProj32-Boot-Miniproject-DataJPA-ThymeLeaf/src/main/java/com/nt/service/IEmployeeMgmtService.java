package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {

	public List<EmployeeDTO> fetchEmployeeDetails();
	public String registerEmployee(EmployeeDTO dto);
	public List<Integer> fetchDeptNos();
	public void removeEmpByNo(int id);
	public EmployeeDTO fetchEmpByid(int id);
	public String modifyEmpId(EmployeeDTO dto);
	
}
