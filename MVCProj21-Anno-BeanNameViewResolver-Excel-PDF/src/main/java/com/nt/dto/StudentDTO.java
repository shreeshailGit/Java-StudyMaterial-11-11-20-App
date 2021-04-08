package com.nt.dto;

public class StudentDTO {
	
	private Integer sno;
	private String sname;
	private String sadd;
	private Float avg;
	
	public StudentDTO(Integer sno, String sname, String sadd, Float avg) {
	
		this.sno = sno;
		this.sname = sname;
		this.sadd = sadd;
		this.avg = avg;
	}
	
	
	

	public Integer getSno() {
		return sno;
	}




	public void setSno(Integer sno) {
		this.sno = sno;
	}




	public String getSname() {
		return sname;
	}




	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSadd() {
		return sadd;
	}

	public void setSadd(String sadd) {
		this.sadd = sadd;
	}

	public Float getAvg() {
		return avg;
	}

	public void setAvg(Float avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "StudentDTO [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", avg=" + avg + "]";
	}
	 
	

}
