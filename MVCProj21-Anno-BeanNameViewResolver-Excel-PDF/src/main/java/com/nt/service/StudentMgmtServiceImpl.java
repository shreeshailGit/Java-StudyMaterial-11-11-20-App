package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.dto.StudentDTO;

@Service("studService")
public class StudentMgmtServiceImpl implements StudentMgmtService {

	@Override
	public List<StudentDTO> getStudentdetails() {
		
		return List.of(new StudentDTO(101,"Amar","dombivli",90.66F)
				             ,new StudentDTO(102,"Atul","Chandivli",89.44F)
				             ,new StudentDTO(103,"Aniket","Tunga",87.65F)
				             ,new StudentDTO(104,"kamesh", "Mahada", 83.44F)
				             ,new StudentDTO(105, "Shuddhodhan", "Muranjan",79.44F)
				             ,new StudentDTO(106,"Sushant", "shivsakti", 70.44F)
				             ,new StudentDTO(106, "Shreeshail", "Adarsh", 67.44F)
				             ,new StudentDTO(107, "Vishal", "Prem-Nagar", 67.44F)
				             ,new StudentDTO(108,"Maya", "shivsakti",95.34F));
	}

}
