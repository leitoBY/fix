package net.mix.spring.dao;

import java.util.List;

import net.mix.spring.model.Department;
import net.mix.spring.model.DepartmentStub;

/**
 * The Interface DepartmentDAO.
 * Data access object for working with db
 */
public interface DepartmentDAO {
	
	/**
	 * Adds the department.
	 *
	 * @param dep the dep
	 */
	public void addDep(Department dep);
	
	/**
	 * Update department.
	 *
	 * @param dep the dep
	 */
	public void updateDep(Department dep);
	
	/**
	 * get all departments.
	 *
	 * @return the list
	 */
	public List<Department> getDeps();
	
	/**
	 * Gets the departmentby Id.
	 *
	 * @param dept_id the dept_id
	 * @return the depby id
	 */
	public Department getDepById(int departmentId);
	
	/**
	 * Removes the department.
	 *
	 * @param dept_id the dept_id
	 */
	public void removeDep(int departmentId);

	/**
	 * list for view with avg_salary
	 *
	 * @return list of departments 
	 */
	
	public List<DepartmentStub> viewAll();
	
	/**
	 * Flush. 
	 * for tests
	 */
	public void flush();


}
