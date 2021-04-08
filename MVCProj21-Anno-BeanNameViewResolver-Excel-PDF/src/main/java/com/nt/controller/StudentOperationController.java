package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentMgmtServiceImpl;

@Controller
public class StudentOperationController {
   
	@Autowired
    private StudentMgmtServiceImpl service;
	
	@GetMapping("/student")
	public String showHomepage() {
		return "home";
	} 
	
	@GetMapping("/pdf_report")
	public String showPDFpage(Map<String,Object> map) {
		//use service
		List<StudentDTO> listDTO = service.getStudentdetails();
		//keep in modelAttribute
		map.put("studentsInfo",listDTO);
	    return "pdfView";	
	}
	
	@GetMapping("/excel_report")
	public String showExcelPage(Map<String,Object> map) {
		//use service
		List<StudentDTO> listDTO = service.getStudentdetails();
		//keep ref in modelAttribute
		map.put("studentsInfo",listDTO);
	      return "excelView";
	}
}//class
