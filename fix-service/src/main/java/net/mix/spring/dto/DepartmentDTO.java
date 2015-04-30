package net.mix.spring.dto;

import java.io.Serializable;
import java.util.List;

import net.mix.spring.model.Worker;

public class DepartmentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int dept_id;
	private String dept_name;
    private Double avg_salary;
    private List<Worker> lWorkers;
    
	public List<Worker> getlWorkers() {
		return lWorkers;
	}
	public void setlWorkers(List<Worker> lWorkers) {
		this.lWorkers = lWorkers;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public Double getAvg_salary() {
		return avg_salary;
	}
	public void setAvg_salary(Double avg_salary) {
		this.avg_salary = avg_salary;
	}
	
    

}