package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dto.EmployeeDTO;
import com.nt.exception.EmployeeNotFoundException;
import com.nt.repository.EmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<EmployeeDTO> fetchEmployeeDetails() {
		List<EmployeeBO> listBO = null;
	    List<EmployeeDTO> listDTO =new ArrayList();
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
		if(fetchEmpByid(id)!=null)   //situation we create exception Line
		   empRepo.deleteById(id);		
	}

	@Override
	public EmployeeDTO fetchEmpByid(int id) {	
        EmployeeBO bo =null;
        EmployeeDTO dto =null;
		//use dao
        Optional<EmployeeBO> opt = empRepo.findById(id);
        if(opt.isEmpty())
        	throw new EmployeeNotFoundException("Problem Occurs");
        else
        	bo = opt.get();
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
		if(fetchEmpByid(dto.getEmpNo())!=null)  //situation we cretae exception Line
		bo = empRepo.save(bo);
		return bo==null?dto.getEmpNo()+"  employee details not found to update":dto.getEmpNo()+"  employee details are found to update";
	}

	@Override
	public Page<EmployeeDTO> getPageData(Pageable pageable) {
		//use Repo
		Page<EmployeeBO> pageBO = empRepo.findAll(pageable);
		//get List Collection
		List<EmployeeBO> listBO = pageBO.getContent();
		//convert listBO to ListDTO  having b.logic and convertions
		List<EmployeeDTO> listDTO = new ArrayList();
			listBO.forEach(bo -> {
				EmployeeDTO dto = new EmployeeDTO();
				BeanUtils.copyProperties(bo, dto);
				dto.setSal(Math.round(dto.getSal()));
				dto.setSerialNo(listDTO.size() + 1);
				dto.setGrossSal(dto.getSal() + dto.getSal() * 0.3f);
				dto.setNetSal(dto.getGrossSal() - dto.getGrossSal() * 0.1f);
				listDTO.add(dto);
			});
			//convert pageBO to pageDTO
			Page<EmployeeDTO> pageDTO = new PageImpl<EmployeeDTO>(listDTO,pageBO.getPageable(),pageBO.getTotalElements());
		return pageDTO;
	}//method

}// class
