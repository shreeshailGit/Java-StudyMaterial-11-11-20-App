package com.nt.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "ipl_team_info")
@Entity
public class IPLTeamInfo implements Serializable {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "ipl_team_id_seq" ,initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.AUTO)
	private Integer teamId;
//	@NotNull
	private String teamName;
//	@NotNull
	private String owner;
	private String  area;
	/**
	 * @return the teamId
	 */
	public Integer getTeamId() {
		return teamId;
	}
	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "IPLTeamInfo [teamId=" + teamId + ", teamName=" + teamName + ", owner=" + owner + ", area=" + area + "]";
	}
	
	
	
}
