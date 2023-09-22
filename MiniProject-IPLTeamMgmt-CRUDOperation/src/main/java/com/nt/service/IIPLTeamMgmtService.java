package com.nt.service;

import com.nt.model.IPLTeamInfo;

public interface IIPLTeamMgmtService {

	public Iterable<IPLTeamInfo> fetchAllIPLTeam();
	public String registerIPLTeam(IPLTeamInfo team);
	
	public IPLTeamInfo getIPLTeamById(Integer teamno);
	public String updateIPLTeam(IPLTeamInfo emp);
	public String deleteIPLTeam(Integer teamno); 
}
