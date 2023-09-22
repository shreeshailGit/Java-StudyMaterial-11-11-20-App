package com.nt.controller;


import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.IPLTeamInfo;
import com.nt.service.IIPLTeamMgmtService;

@Controller
public class IPLTeamOperationController {

	@Autowired
	private IIPLTeamMgmtService service;
	
	
	@GetMapping("/")
	public String showHomePage() {//To show home page
		//return LVN
		return "home";
	}
	
	@GetMapping("/iplteam_report")
	public String showIPLTeamReport(Map<String,Object> map) {
		//use service
		Iterable<IPLTeamInfo> teamList = service.fetchAllIPLTeam();
		System.err.println("teamList ="+teamList);
		//put result in modelAttribute
		map.put("teamList", teamList);
		//return LVN
		return "show_team_report";
	}
	
	@GetMapping("/register")
	public String showRegisterTeam(@ModelAttribute("team") IPLTeamInfo team) {
		//return LVN
		return "register_team";
	}
	
	@PostMapping("/register")
	public String showFormforSaveIPLTeam(@ModelAttribute("team") IPLTeamInfo team,RedirectAttributes attr) {
		//use service
		String msg = service.registerIPLTeam(team);
		//put result in modelAttribute
		attr.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:/iplteam_report";
	}
	
	@GetMapping("/team_edit")
	public String getIPLTeamByNo(@RequestParam("no")Integer teamno,@ModelAttribute("team") IPLTeamInfo team) {
		//use service
		IPLTeamInfo team1 = service.getIPLTeamById(teamno);
		//copy data
		BeanUtils.copyProperties(team1,team);
		return "update_team";
	}
	@PostMapping("/team_edit")
	public String editIPLTeam(RedirectAttributes attr,@ModelAttribute("emp") IPLTeamInfo team) {
		//use service
		String msg = service.updateIPLTeam(team);
		attr.addFlashAttribute("resultMsg", msg);
		return "redirect:/iplteam_report";
	}
	@GetMapping("/team_delete")
	public String deleteIPLTeam(RedirectAttributes attr,@RequestParam("no")Integer teamno) {
		//use service
		String msg = service.deleteIPLTeam(teamno);
		attr.addFlashAttribute("resultMsg", msg);
		return "redirect:/iplteam_report";
	}
	
}
