package net.mix.spring.model;

import javax.persistence.Entity;

@Entity
public class DepartmentStub {

	private int departmentId;
	private String departmentName;
	private Double avgSalary;
	
	
	public DepartmentStub(int departmentId, String departmentName, Double avgSalary) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.avgSalary = avgSalary;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public Double getAvgSalary() {
		return avgSalary;
	}


	public void setAvgSalary(Double avgSalary) {
		this.avgSalary = avgSalary;
	}


	
	
	
		
}
