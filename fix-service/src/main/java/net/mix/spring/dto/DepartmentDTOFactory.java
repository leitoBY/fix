package net.mix.spring.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import net.mix.spring.model.Department;
import net.mix.spring.model.Worker;


/**
 * A factory for creating DepartmentDTO objects.
 */ 
@Component
public class DepartmentDTOFactory {
	
	/**
	 * Creates a new DepartmentDTO object.
	 *
	 * @param department the department
	 * @return the department dto
	 */
	public DepartmentDTO createDTO(Department department) {
		
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartmentId(department.getDepartmentId());
		dto.setDepartmentName(department.getDeptartmentName());
		dto.setAvgSalary(department.getAvgSalary());
		List<Worker> list = new ArrayList<Worker>(department.getWorkersList());
		dto.setListWorkers(list);
		return dto;
	}
	
	/**
	 * Creates a new DepartmentDTO object.
	 *
	 * @param departments the departments
	 * @return the list< department dto>
	 */
	public List<DepartmentDTO> createDTOs(List<Department> departments){
		List<DepartmentDTO> departmentDTOs = new ArrayList<DepartmentDTO>();
		if (departments != null) {			
			for (Department d : departments) {
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setDepartmentId(d.getDepartmentId());
				departmentDTO.setDepartmentName(d.getDeptartmentName());
				departmentDTO.setAvgSalary(d.getAvgSalary());
				List<Worker> list = new ArrayList<Worker>(d.getWorkersList());
				departmentDTO.setListWorkers(list);
				departmentDTOs.add(departmentDTO);
			}			
		}
		return departmentDTOs;
	}
	
	/**
	 * Creates a new DepartmentDTO object.
	 *
	 * @param dto the dto
	 * @return the department
	 */
	public Department createModel(DepartmentDTO dto) {
		
		Department model = new Department();
		model.setDepartmentId(dto.getDepartmentId());
		model.setDeptartmentName(dto.getDepartmentName());
		model.setAvgSalary(dto.getAvgSalary());
		if(dto.getListWorkers()!=null) {
			Set<Worker> set = new HashSet<Worker>(dto.getListWorkers());
			model.setWorkersList(set);
			return model;
		}
		else {
			return model;
		}
		
	}

}
