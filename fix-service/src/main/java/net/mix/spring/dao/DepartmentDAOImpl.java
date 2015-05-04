package net.mix.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.mix.spring.model.Department;
import net.mix.spring.model.DepartmentStub;
import net.mix.spring.model.Worker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * The class DepartmentDAOImpl.
 * Data access object for working with db
 */
@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	
	
	private static final Logger logger = LoggerFactory.getLogger(WorkerDAOImpl.class);
	 
    
    @Autowired
    private SessionFactory sessionFactory;
    

    /**
	 * Adds the department.
	 *
	 * @param dep the dep
	 */
    public void addDep(Department dep) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(dep);
        logger.info("Department {} saved successfully, Department Details= Id: {} Average Salary {}",
                dep.getDeptartmentName(), dep.getDepartmentId(), dep.getAvgSalary());
    }

    /**
	 * Update department.
	 *
	 * @param dep the dep
	 */
    public void updateDep(Department dep) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(dep);
        logger.info("Department {} updated successfully, Department Details= Id: {} Average Salary {}",
                dep.getDeptartmentName(), dep.getDepartmentId(), dep.getAvgSalary());
    }
 
    /**
	 * get all departments.
	 *
	 * @return the list
	 */
    @SuppressWarnings("unchecked")
    public List<Department> getDeps() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Department> depsList = session.createQuery("from Department").list();
        for(Department dep : depsList){
        	logger.info("Department Id: {} Name: {}",
                    dep.getDepartmentId(), dep.getDeptartmentName());
        }
        return depsList;
    }
 
    /**
	 * Gets the departmentby Id.
	 *
	 * @param dept_id the dept_id
	 * @return the depby id
	 */
    public Department getDepById(int departmentId) {
        Session session = this.sessionFactory.getCurrentSession();      
        Department dep = (Department) session.load(Department.class, new Integer(departmentId));
        logger.info("Department {} loaded successfully, Department Details= Id: {} Average Salary {}",
        		dep.getDeptartmentName(), dep.getDepartmentId(), dep.getAvgSalary());
        return dep;
    }
    
    /**
	 * Removes the department.
	 *
	 * @param dept_id the dept_id
	 */
    public void removeDep(int departmentId) {
        Session session = this.sessionFactory.getCurrentSession();
        Department dep = (Department) session.load(Department.class, new Integer(departmentId));
        Set<Worker> list = dep.getWorkersList();
        logger.info("list"+list);
        if(null != dep){
        	for(Worker w : list) {
        		session.delete(w);
        	}
        	
            session.delete(dep);
        }
        logger.info("Department {} deleted successfully" ,dep.getDeptartmentName());
    }
	
	/**
	 * list for view with avg_salary
	 *
	 * @return list of departments 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DepartmentStub> viewAll() {
		Session session = this.sessionFactory.getCurrentSession();
        List<DepartmentStub> viewsList = new ArrayList<DepartmentStub>();
        viewsList = session.createQuery("select new net.mix.spring.model.DepartmentStub(d.departmentId, d.departmentName, avg(w.salary)) "
        		+ "from Worker w right join w.department d group by d.departmentId").list();
               
        return viewsList;
	}

	/**
	 * Flush. 
	 * for tests
	 */
	public void flush() {
		Session session = this.sessionFactory.getCurrentSession();
		session.flush();
	}






}
