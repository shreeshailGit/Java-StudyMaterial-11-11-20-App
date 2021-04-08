package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.nt.dto.EmployeeDTO;
import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {
	@Autowired
	private com.nt.validator.EmployeeValidator validator;
    @Autowired
	private IEmployeeMgmtService service;
   
	@GetMapping("/welcome")
	public String showHome() {
		return "home";//lnv for home
	}
	
	@GetMapping("/list_Emps")
	public String showEmployees(Map<String,Object> map) {
		List<EmployeeDTO> listDTO =null;
		//use service 
		listDTO = service.fetchEmployeeDetails();
		//keep results in model attriute
		map.put("empsInfo",listDTO);
		return "show_report";
	}
	
	@GetMapping("/saveEmp")
    public String showEmpRegistraionPage(@ModelAttribute("empFrm") Employee emp) {
		return "employee_register";
    }//
	
	@PostMapping("/saveEmp")//for post back request
	public String saveEmployee(RedirectAttributes map, @ModelAttribute("empFrm") Employee emp,
			                                                BindingResult errors ) {
		
		System.out.println(emp.toString());
		System.out.println("vflag update:: "+emp.getVflag());
		
		if(emp.getVflag().equalsIgnoreCase("no")) { //enable server side form validations only when client form   validations are not done	
		//perform form validation
		if(validator.supports(emp.getClass()))
			 validator.validate(emp, errors);
		}
		
		//b.logic or application logic error
		if(emp.getJob().equalsIgnoreCase("ceo") || emp.getJob().equalsIgnoreCase("actor") ||emp.getJob().equalsIgnoreCase("leader")) {
			errors.rejectValue("job","blocked.jobs");
		}
		
		//if form validation errors are there ..launch form page
		if(errors.hasErrors()) 
			return "employee_register";
			
		
		EmployeeDTO dto = new EmployeeDTO();
		// List<EmployeeDTO> listDTO =null;
			String result = null;
			//convert model to dto
			BeanUtils.copyProperties(emp,dto);
			//use service
			result = service.registerEmployee(dto);
		
			//keep results in Flash attriute(Special Map object)
			map.addFlashAttribute("resultMsg",result);
			return "redirect:list_Emps";  //bcz of redirect we can solve double posting problem
	}
	
	@GetMapping("/deleteEmp")
	public String removeEmployee(RedirectAttributes redirect,
			                    @RequestParam int eno) {
		//use service
		service.removeEmpByNo(eno);
		//add result to flash attribute
		redirect.addFlashAttribute("resultMsg",eno+" Emp Id deleted");
		return "redirect:list_Emps";
	}
	
	@GetMapping("/editEmp")
	public String showEditFormPage(@ModelAttribute Employee emp,
			                                             @RequestParam int eno) {
		EmployeeDTO dto =null;
		//use service
		dto = service.fetchEmpByid(eno);
		//convert dto to model
		BeanUtils.copyProperties(dto,emp);
		//return lvn
		return "employee_edit";
	}
	
	@PostMapping("/editEmp")
	public String updateEmployee(RedirectAttributes redirect ,@ModelAttribute Employee emp , 
			                              BindingResult errors ) {
		
		System.out.println("vflag update:: "+emp.getVflag());
		
		        if(emp.getVflag().equalsIgnoreCase("no")) { //enable server side form validations only when client form   validations are not done
		            //perform form validation
				      if(validator.supports(emp.getClass()))
					     validator.validate(emp, errors);
		        }
					
				//b.logic or application logic error
				if(emp.getJob().equalsIgnoreCase("ceo") || emp.getJob().equalsIgnoreCase("actor") ||emp.getJob().equalsIgnoreCase("leader")) {
					errors.rejectValue("job","blocked.jobs");
				}
				
				//if form validation errors are there ..launch form page
				if(errors.hasErrors()) {
					return "employee_edit";
				}
				
				
		String result =null;
		EmployeeDTO dto =null;
		dto =new EmployeeDTO();
		//convert dto to emp
		BeanUtils.copyProperties(emp,dto);
		//use service
		result = service.modifyEmpId(dto);
		//add result to Flash attribute
		redirect.addFlashAttribute("resultMsg",result);
		//perform redirection
		return "redirect:list_Emps";
		
	}
	
	@ModelAttribute("deptsInfo")//constrcting referance data/initial data for select box
	public List<Integer> populateDeptNos() {
		System.out.println("EmployeeController.populateDeptNos()");
		//List<Integer> deptNosList =List.of(10, 20, 30, 40);
		
		/*List<Integer> deptNosList = new ArrayList();
		deptNosList.add(10);
		deptNosList.add(20);
		deptNosList.add(30);
		deptNosList.add(40);*/
		List<EmployeeDTO> listDTO = null;
		//use service
		return service.fetchDeptNos();	
	}//method
	
	@PostMapping("/report_paging")
	public String showPageDetails(Map<String,Object> map,
			                        @PageableDefault(page=0 ,size=3,sort = "ename" ,direction = Direction.ASC) Pageable pageable){
		//use service
		Page<EmployeeDTO> pageDTO = service.getPageData(pageable);
		//keep pageDTO obj as model attrobute
	     map.put("page",pageDTO);
	      //return lvn
		return "show_paging_report";
	}//method
	
	
	

}//class
