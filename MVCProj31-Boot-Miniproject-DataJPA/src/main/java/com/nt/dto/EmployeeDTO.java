package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO  implements Serializable{
    private Integer serialNo;
	private Integer empNo;
	private String ename;
	private String job;
	private Float sal;
	private Integer deptno;
	private Float grossSal;
	private Float netSal;
	
	public Integer getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public Float getGrossSal() {
		return grossSal;
	}
	public void setGrossSal(Float grossSal) {
		this.grossSal = grossSal;
	}
	public Float getNetSal() {
		return netSal;
	}
	public void setNetSal(Float netSal) {
		this.netSal = netSal;
	}
	
	@Override
	public String toString() {
		return "EmployeeDTO [serialNo=" + serialNo + ", empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal="
				+ sal + ", deptno=" + deptno + ", grossSal=" + grossSal + ", netSal=" + netSal + "]";
	}
	
	
	
}//class
