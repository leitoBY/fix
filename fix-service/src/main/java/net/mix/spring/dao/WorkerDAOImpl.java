package net.mix.spring.dao;
 
import java.util.List;
 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 

import net.mix.spring.model.Worker;
/**
 * The Interface WorkerDAO.
 * Data access object for working with db
 */ 
@Repository
public class WorkerDAOImpl implements WorkerDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(WorkerDAOImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
    /**
     * Adds the worker.
     *
     * @param w the w
     */ 
    public void addWorker(Worker w) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(w);
        logger.info("New worker saved successfully, Worker Details= Id: {} firstname: {} lastname: {}, salary: {}",
                w.getId(), w.getFirstName(), w.getLastName(), w.getSalary());
    }
    /**
     * Update worker.
     *
     * @param w the w
     */
    public void updateWorker(Worker w) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(w);
        logger.info("Worker updated successfully, Worker Details= Id: {} firstname: {} lastname: {}, salary: {}",
                w.getId(), w.getFirstName(), w.getLastName(), w.getSalary());
    }
    /**
     * get List of all workers.
     *
     * @return the list
     */
    @SuppressWarnings("unchecked")
    public List<Worker> listWorkers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Worker> workersList = session.createQuery("from Worker").list();
        for(Worker w : workersList){
            logger.info("Worker Id: {} firstname: {} lastname: {}",
            		w.getId(), w.getFirstName(), w.getLastName());
        }
        return workersList;
    }
    /**
     * Gets the worker by id.
     *
     * @param id the id
     * @return the worker by id
     */
    public Worker getWorkerById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Worker w = (Worker) session.load(Worker.class, new Integer(id));
        logger.info("New worker loaded successfully, Worker Details= Id: {} firstname: {} lastname: {}, salary: {}",
                w.getId(), w.getFirstName(), w.getLastName(), w.getSalary());
        return w;
    }
    /**
     * Removes the worker.
     *
     * @param id the id
     */
    public void removeWorker(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Worker w = (Worker) session.load(Worker.class, new Integer(id));
        if(null != w){
            session.delete(w);
        }
        logger.info("Worker {} deleted successfully", w.getFirstName());
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