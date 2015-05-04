package net.mix.spring.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * The Class Department.
 */
@Entity
@Table (name="Department")
public class Department {
	
	@Id
	@Column (name="departmentId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int departmentId;
	private String departmentName;
	private Double avgSalary;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDeptartmentName() {
		return departmentName;
	}
	public void setDeptartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Double getAvgSalary() {
		return avgSalary;
	}
	public void setAvgSalary(Double avgSalary) {
		this.avgSalary = avgSalary;
	}
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Worker> workersList;

	public Set<Worker> getWorkersList() {
		return workersList;
	}
	public void setWorkersList(Set<Worker> workersList) {
		this.workersList = workersList;
	}
	
	
}
