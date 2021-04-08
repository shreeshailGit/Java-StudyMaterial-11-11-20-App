package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dto.EmployeeDTO;
import com.nt.repository.EmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<EmployeeDTO> fetchEmployeeDetails() {
		List<EmployeeBO> listBO = null;
	    List<EmployeeDTO> listDTO = new ArrayList();
		// use dao
		listBO = (List<EmployeeBO>) empRepo.findAll();

		// convert listBO to listDTO
		listBO.forEach(bo -> {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSal(Math.round(dto.getSal()));
			dto.setSerialNo(listDTO.size() + 1);
			dto.setGrossSal(dto.getSal() + dto.getSal() * 0.3f);
			dto.setNetSal(dto.getGrossSal() - dto.getGrossSal() * 0.1f);
			listDTO.add(dto);
		});
		return listDTO;
	}// method

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo = new EmployeeBO();
		// convert dto to bo
		BeanUtils.copyProperties(dto, bo);
		// use dao
		bo = empRepo.save(bo);

		return bo!=null ?bo.getEmpNo()+" Employee registred" : "Employee not registred";
	}

	@Override
	public List<Integer> fetchDeptNos() {
		List<Integer> listBO = null;
		// use dao
		listBO = empRepo.getAlldeptNo();
		return listBO;
	}

	@Override
	public void removeEmpByNo(int id) {
		// use dao
		empRepo.deleteById(id);
		//return count == 0 ? id + " emp not found for deletion" : id + " emp found & deleted";
	}

	@Override
	public EmployeeDTO fetchEmpByid(int id) {
		
        EmployeeBO bo =null;
        EmployeeDTO dto =null;
		//use dao
        bo = empRepo.findById(id).get();
     // convert bo  to dto
		dto = new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public String modifyEmpId(EmployeeDTO dto) {
		System.out.println(dto);
		// convert dto to bo
		EmployeeBO bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		// use dao
		bo = empRepo.save(bo);
		return bo==null?dto.getEmpNo()+"  employee details not found to update":dto.getEmpNo()+"  employee details are found to update";
	}

}// class
