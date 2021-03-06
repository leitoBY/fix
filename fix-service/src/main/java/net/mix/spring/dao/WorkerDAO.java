package net.mix.spring.dao;
 
import java.util.List;
 
import net.mix.spring.model.Worker;
 

/**
 * The Interface WorkerDAO.
 * Data access object for working with db
 */
public interface WorkerDAO {
 
    /**
     * Adds the worker.
     *
     * @param w the w
     */
    public void addWorker(Worker w);
    
    /**
     * Update worker.
     *
     * @param w the w
     */
    public void updateWorker(Worker w);
    
    /**
     * get List of all workers.
     *
     * @return the list
     */
    public List<Worker> listWorkers();
    
    /**
     * Gets the worker by id.
     *
     * @param id the id
     * @return the worker by id
     */
    public Worker getWorkerById(int id);
    
    /**
     * Removes the worker.
     *
     * @param id the id
     */
    public void removeWorker(int id);
    /**
	 * Flush. 
	 * for tests
	 */
    public void flush();
}