package net.mix.spring.dao;

import java.util.List;

import net.mix.spring.model.Department;

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
	 * List department.
	 *
	 * @return the list
	 */
	public List<Department> listDeps();
	
	/**
	 * Gets the departmentby id.
	 *
	 * @param dept_id the dept_id
	 * @return the depby id
	 */
	public Department getDepbyId(int dept_id);
	
	/**
	 * Removes the department.
	 *
	 * @param dept_id the dept_id
	 */
	public void removeDep(int dept_id);

	/**
	 * Counts avetage department salary.
	 *
	 * @param dep the dep
	 * @return the double
	 */
	Double avgsalary(Department dep);
	
	/**
	 * Flush. 
	 * for tests
	 */
	void flush();


}
