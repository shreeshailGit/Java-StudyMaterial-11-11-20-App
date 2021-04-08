package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.dto.StudentDTO;

@Controller
public class DataRenderingController {

	/*@GetMapping(value = "/welcome")
	public String processData(Model model) {
		System.out.println("DataRenderingController.processData()");
		System.out.println(((BindingAwareModelMap) model).size());
		System.out.println(model.getClass());
		model.addAttribute("msg", "Welcome");
		System.out.println(((BindingAwareModelMap) model).size());
		return "display";
	}*/
	
	/*@GetMapping(value = "/welcome")
	public String processData(Model model) {
		System.out.println("DataRenderingController.processData()");
	   //Arrays
		String[] names = new String[]{"raja","rani","Mahesh","rajesh"};
		
		List<String> fruitsList = List.of("apple","graphes","mango","bannana"); //java9 ..Immutable list
		
		Set<Long> phoneSet = Set.of(9999999L,8888888L,7777777L);
		
		Map<String,Integer> ageMap = Map.of("raja",30,"rani",25,"Mahesh",23,"rajesh",20);
	  //add them as modelAttribute
		model.addAttribute("namesInfo",names);
		model.addAttribute("fruitsInfo",fruitsList);
		model.addAttribute("phonesInfo",phoneSet);
		model.addAttribute("agesInfo",ageMap);
		
		return "display";
	}*/
	
	@GetMapping(value = "/welcome")
	public String processData(Model model) {
		System.out.println("DataRenderingController.processData()");
	   //Collection
		List<StudentDTO> listDTO = List.of(new StudentDTO(101, "raja", "hyd"),
				                           new StudentDTO(102, "rani", "vizag"),
				                           new StudentDTO(103, "rajesh", "delhi")
				                           );
		//add model attribute name 
		model.addAttribute("studList", listDTO);
		return "display";
	}
	
	/*@GetMapping(value = "/welcome")
	public String processData(Map<String,Object> map) {
		System.out.println("DataRenderingController.processData()");
		System.out.println(map.getClass());
		map.put("msg", "Welcome");
		System.out.println("size:::"+map.size());
		return "display";
	}   */
}
