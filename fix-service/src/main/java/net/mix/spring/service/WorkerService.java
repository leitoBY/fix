package net.mix.spring.service;
 
import java.util.List;

import net.mix.spring.dto.WorkerDTO;
 
/**
 * The Interface WorkerService.
 * service for work with data(workers)
 */
public interface WorkerService {
 
    /**
     * Save worker to db
     *
     * @param workerDTO the worker dto
     */
    public void saveWorker(WorkerDTO workerDTO);
    
    /**
     * Edits the worker in db
     *
     * @param workerDTO the worker dto
     */
    public void editWorker(WorkerDTO workerDTO);
    
    /**
     *  get list of all Workers from db
     *
     * @return the list
     */
    public List<WorkerDTO> getWorkers();
    
    /**
     * Gets the worker with specified id
     *
     * @param workerId the worker id
     * @return the worker
     */
    public WorkerDTO getWorker(int workerId);
    
    /**
     * Delete worker by id from db
     *
     * @param workerId the worker id
     */
    public void deleteWorker(int workerId);
     
}