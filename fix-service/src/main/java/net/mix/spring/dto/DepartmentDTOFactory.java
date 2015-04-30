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
		
		dto.setDept_id(department.getDept_id());
		dto.setDept_name(department.getDept_name());
		dto.setAvg_salary(department.getAvg_salary());
		List<Worker> list = new ArrayList<Worker>(department.getWorkersList());
		dto.setlWorkers(list);
		
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
				departmentDTO.setDept_id(d.getDept_id());
				departmentDTO.setDept_name(d.getDept_name());
				departmentDTO.setAvg_salary(d.getAvg_salary());
				List<Worker> list = new ArrayList<Worker>(d.getWorkersList());
				departmentDTO.setlWorkers(list);
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
		model.setDept_id(dto.getDept_id());
		model.setDept_name(dto.getDept_name());
		model.setAvg_salary(dto.getAvg_salary());
		if(dto.getlWorkers()!=null) {
		Set<Worker> set = new HashSet<Worker>(dto.getlWorkers());
		model.setWorkersList(set);
		return model; }
		else return model;
		
	}

}
