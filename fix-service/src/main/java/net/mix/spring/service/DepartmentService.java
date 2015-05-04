package net.mix.spring.service;

import java.util.List;

import net.mix.spring.dto.DepartmentDTO;
import net.mix.spring.model.DepartmentStub;


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
    public List<DepartmentDTO> getDepartments();
    
    /**
     * Gets the department with specified id
     *
     * @param departmentId the departmentId
     * @return dep
     */
    public DepartmentDTO getDepartment(int departmentId);
    
    /**
     * Delete department by id from db
     *
     * @param departmentId the departmentId
     */
    public void deleteDep(int departmentId);
    
    /**
     * get list of all deps from db with avg salary
     *
     * @return list of deps
     */
    public List<DepartmentStub> viewsList();
    

}
