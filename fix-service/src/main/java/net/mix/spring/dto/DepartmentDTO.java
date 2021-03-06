package net.mix.spring.dto;

import java.io.Serializable;
import java.util.List;

import net.mix.spring.model.Worker;

public class DepartmentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int departmentId;
	private String departmentName;
    private Double avgSalary;
    private List<Worker> listWorkers;
    
	public List<Worker> getListWorkers() {
		return listWorkers;
	}
	public void setListWorkers(List<Worker> listWorkers) {
		this.listWorkers = listWorkers;
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