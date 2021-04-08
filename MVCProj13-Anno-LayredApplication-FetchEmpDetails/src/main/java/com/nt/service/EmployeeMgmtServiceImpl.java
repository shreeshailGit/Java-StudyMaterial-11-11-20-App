package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;
@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
   @Autowired
	private IEmployeeDAO dao;
	
   @Override
	public List<EmployeeDTO> fetchEmployeeDetails() {
	   List<EmployeeBO> listBO = null;
		List<EmployeeDTO> listDTO = new ArrayList();
		//use dao
		listBO=dao.getAllEmployees();
		
		//convert listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSal(Math.round(dto.getSal()));
			dto.setSerialNo(listDTO.size()+1);
			dto.setGrossSal(dto.getSal() + dto.getSal()*0.3f);
			dto.setNetSal(dto.getGrossSal() - dto.getGrossSal()*0.1f);
			listDTO.add(dto);
		});
	   return listDTO;
	}//method

}//class
