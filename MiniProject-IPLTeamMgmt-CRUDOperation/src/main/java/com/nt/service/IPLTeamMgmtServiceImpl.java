package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.IPLTeamInfo;
import com.nt.repository.IIPLTeamRepository;

@Service("iplTeamService")
public class IPLTeamMgmtServiceImpl implements IIPLTeamMgmtService {

	@Autowired
	private IIPLTeamRepository repo;
	

	@Override
	public Iterable<IPLTeamInfo> fetchAllIPLTeam() {
		Iterable<IPLTeamInfo> iplTeamList = repo.findAll();
		System.err.println("iplTeamList"+iplTeamList);
		return iplTeamList;
	}
	@Override
	public String registerIPLTeam(IPLTeamInfo team) {
		return "IPL Team is register with Id value :"+repo.save(team).getTeamId();
	}
	@Override
	public IPLTeamInfo getIPLTeamById(Integer teamno) {
		IPLTeamInfo team = repo.findById(teamno).orElseThrow(()-> new IllegalArgumentException());
		 return team;
	}
	
	@Override
	public String updateIPLTeam(IPLTeamInfo team) {
		return "IPLTeam is Updated with Id value :"+repo.save(team).getTeamId();
	}
	@Override
	public String deleteIPLTeam(Integer teamno) {
		repo.deleteById(teamno);
		return teamno+" Id IPL Team is deleted";
	}

}
