package net.mix.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.mix.spring.model.Department;
import net.mix.spring.model.Worker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkerDAOImpl.class);
	 
    @Autowired
    private SessionFactory sessionFactory;
    

    public void addDep(Department dep) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(dep);
        logger.info("Department saved successfully, Department Details="+dep);
    }

    
    public void updateDep(Department dep) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(dep);
        logger.info("Department updated successfully, Department Details="+dep);
    }
 
    @SuppressWarnings("unchecked")

    public List<Department> listDeps() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Department> depsList = session.createQuery("from Department").list();
        for(Department dep : depsList){
            logger.info("Department List::"+dep);
        }
        return depsList;
    }
 

    public Department getDepbyId(int dept_id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Department dep = (Department) session.load(Department.class, new Integer(dept_id));
        logger.info("Department loaded successfully, Department details="+dep);
        return dep;
    }
 

    
    public void removeDep(int dept_id) {
        Session session = this.sessionFactory.getCurrentSession();
        Department dep = (Department) session.load(Department.class, new Integer(dept_id));
        Set<Worker> list = dep.getWorkersList();
        logger.info("list"+list);
        if(null != dep){
        	for(Worker w : list) {
        		session.delete(w);
        	}
        	
            session.delete(dep);
        }
        logger.info("Department deleted successfully, Department details="+dep);
    }
    
    
	public Double avgsalary(Department dep) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Double> listavg =session.createSQLQuery("SELECT avg(Worker.salary) FROM Worker RIGHT JOIN Department where Worker.dept_id=Department.dept_id group by Department.dept_id").list();
		List<Department> listdeps = listDeps();
		int count = 0;
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		for(Double d : listavg) {
			map.put(listdeps.get(count).getDept_id(), d);
			count++;
		}
		
		double avg = 0D;
		for (Map.Entry<Integer, Double> pair : map.entrySet()) {
			if(dep.getDept_id()==pair.getKey()) 
				avg = pair.getValue();
			
		}
		
		
		return avg;
	}

	
	public void flush() {
		Session session = this.sessionFactory.getCurrentSession();
		session.flush();
		
	}






}
