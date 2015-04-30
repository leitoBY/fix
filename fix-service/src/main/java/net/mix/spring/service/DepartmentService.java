package net.mix.spring.service;

import java.util.List;

import net.mix.spring.dto.DepartmentDTO;


/**
 * The Interface DepartmentService.
 * service for work with data (departments)
 */
public interface DepartmentService {
	
	
	/**
	 * Save department to db
	 *
	 * @param departmentDTO
	 */
	public void saveDep(DepartmentDTO departmentDTO);
    
    /**
     * Edits department in db
     *
     * @param departmentDTO 
     */
    public void editDep(DepartmentDTO departmentDTO);
    
    /**
     * get list of all Departments from db
     *
     * @return the list
     */
    public List<DepartmentDTO> listDeps();
    
    /**
     * Gets the department with specified id
     *
     * @param department_id the department_id
     * @return dep
     */
    public DepartmentDTO getDep(int department_id);
    
    /**
     * Delete department by id from db
     *
     * @param department_id the department_id
     */
    public void deleteDep(int department_id);
    
    /**
     * Count average salary
     *
     * @param departmentDTO the department dto
     */
    public void countSalary(DepartmentDTO departmentDTO);
    

}
