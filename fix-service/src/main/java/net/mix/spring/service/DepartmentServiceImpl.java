package net.mix.spring.service;

import java.util.List;

import net.mix.spring.dao.DepartmentDAO;
import net.mix.spring.dto.DepartmentDTO;
import net.mix.spring.dto.DepartmentDTOFactory;
import net.mix.spring.model.Department;
import net.mix.spring.model.DepartmentStub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class DepartmentServiceImpl.
 * service for work with data (departments)
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDAO departmentDAO;
	@Autowired
	private DepartmentDTOFactory departmentFactory;

	/**
	 * Save department to db
	 *
	 * @param departmentDTO
	 */
    @Transactional
    public void saveDep(DepartmentDTO departmentDTO) {
       departmentDAO.addDep(departmentFactory.createModel(departmentDTO));
    }

    /**
     * Edits department in db
     *
     * @param departmentDTO 
     */
    @Transactional
    public void editDep(DepartmentDTO departmnetDTO) {
    	departmentDAO.updateDep(departmentFactory.createModel(departmnetDTO));
    }
 
    /**
     * get list of all Departments from db
     *
     * @return the list
     */
    @Transactional
    public List<DepartmentDTO> getDepartments() {
    	
    	List<Department> departments = departmentDAO.getDeps();
        return departmentFactory.createDTOs(departments);
    }
 
    /**
     * Gets the department with specified id
     *
     * @param departmentId the departmentId
     * @return dep
     */
    @Transactional
    public DepartmentDTO getDepartment(int departmentId) {
    	Department department = departmentDAO.getDepById(departmentId);
        return departmentFactory.createDTO(department);
    }
 
    /**
     * Delete department by id from db
     *
     * @param departmentId the departmentId
     */
    @Transactional
    public void deleteDep(int departmentId) {
        this.departmentDAO.removeDep(departmentId);
    }


    /**
	 * list for view with avg_salary
	 *
	 * @return list of departments 
	 */
    @Transactional
	public List<DepartmentStub> viewsList() {
		return departmentDAO.viewAll(); 
	}



}
