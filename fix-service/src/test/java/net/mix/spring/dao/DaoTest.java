package net.mix.spring.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.mix.spring.model.Department;
import net.mix.spring.model.Worker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-context.xml"})

public class DaoTest {
	@Autowired 
	private DepartmentDAO departmentDAO;
	@Autowired
	private WorkerDAO workerDAO;
	
	@Test
	@Transactional
	public void istest() throws Exception {
		//test department add and list
		Department d1 = new Department();
		Department d2 = new Department();
		Department d3 = new Department();
		d1.setDept_name("dep1");
		d2.setDept_name("dep2");
		d3.setDept_name("dep3");
		List<Department> expecteddepartments = new ArrayList<Department>();
		expecteddepartments.add(d1);
		expecteddepartments.add(d2);
		expecteddepartments.add(d3);
		departmentDAO.addDep(d1);
		departmentDAO.addDep(d2);
		departmentDAO.addDep(d3);
		List<Department> actuaDepartments = departmentDAO.listDeps();
		assertEquals(d1, departmentDAO.getDepbyId(d1.getDept_id()));
		assertEquals(expecteddepartments, actuaDepartments);
		//test department update
		d2.setDept_name("department2");
		departmentDAO.updateDep(d2);
		assertEquals("department2", departmentDAO.getDepbyId(d2.getDept_id()).getDept_name());
		//test worker add + list
		Worker dw1 = new Worker();
		Worker dw2 = new Worker();
		Worker dw3 = new Worker();
		Worker ddw1 = new Worker();
		Worker ddw2 = new Worker();
		Worker ddw3 = new Worker();
		Worker dddw1 = new Worker();
		dw1.setFirstName("firstname1");
		dw1.setLastName("lastName1");
		dw1.setDepartment(d1);
		dw1.setSalary(100D);
		dw2.setFirstName("firstname2");
		dw2.setLastName("lastName2");
		dw2.setDepartment(d1);
		dw2.setSalary(200D);
		dw3.setFirstName("firstname3");
		dw3.setLastName("lastName3");
		dw3.setDepartment(d1);
		dw3.setSalary(300D);
		ddw1.setFirstName("firstname11");
		ddw1.setLastName("lastName11");
		ddw1.setDepartment(d2);
		ddw1.setSalary(500D);
		ddw2.setFirstName("firstname22");
		ddw2.setLastName("lastName22");
		ddw2.setDepartment(d2);
		ddw2.setSalary(600D);
		ddw3.setFirstName("firstname33");
		ddw3.setLastName("lastName33");
		ddw3.setDepartment(d2);
		ddw3.setSalary(700D);
		dddw1.setFirstName("firstname111");
		dddw1.setLastName("lastName111");
		dddw1.setDepartment(d3);
		dddw1.setSalary(1000D);
		workerDAO.addWorker(dw1);
		workerDAO.addWorker(dw2);
		workerDAO.addWorker(dw3);
		workerDAO.addWorker(ddw1);
		workerDAO.addWorker(ddw2);
		workerDAO.addWorker(ddw3);
		workerDAO.addWorker(dddw1);
		Set<Worker> wSet1 = new HashSet();
		Set<Worker> wSet2 = new HashSet();
		Set<Worker> wSet3 = new HashSet();
		wSet1.add(dw1);
		wSet1.add(dw2);
		wSet1.add(dw3);
		wSet2.add(ddw1);
		wSet2.add(ddw2);
		wSet2.add(ddw3);
		wSet3.add(dddw1);
		d1.setWorkersList(wSet1);
		d2.setWorkersList(wSet2);
		d3.setWorkersList(wSet3);
		departmentDAO.updateDep(d1);
		departmentDAO.updateDep(d2);
		departmentDAO.updateDep(d3);
		
		List<Worker> expectedworkers = new ArrayList<Worker>();
		expectedworkers.add(dw1);
		expectedworkers.add(dw2);
		expectedworkers.add(dw3);
		expectedworkers.add(ddw1);
		expectedworkers.add(ddw2);
		expectedworkers.add(ddw3);
		expectedworkers.add(dddw1);
		List<Worker> actualworkers = workerDAO.listWorkers();
		assertEquals(dw2, workerDAO.getWorkerById(d2.getDept_id()));
		assertEquals(expectedworkers, actualworkers);
		
		//test worker update
		dw2.setFirstName("alex");
		workerDAO.updateWorker(dw2);
		assertEquals("alex", workerDAO.getWorkerById(dw2.getId()).getFirstName());
		//test worker delete
		workerDAO.removeWorker(dddw1.getId());
		workerDAO.flush();
		//test department delete
		
		departmentDAO.removeDep(d1.getDept_id());
		departmentDAO.flush();
		
		
		
		
		
		
		
	}
	
	

}
