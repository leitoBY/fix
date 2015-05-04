package net.mix.spring.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.mix.spring.dao.WorkerDAO;
import net.mix.spring.dto.WorkerDTO;
import net.mix.spring.dto.WorkerDTOFactory;
import net.mix.spring.model.Worker;
/**
 * Class WorkerServiceImpl.
 * service for work with data (workers)
 */ 
@Service
public class WorkerServiceImpl implements WorkerService {
     
    @Autowired
	private WorkerDAO workerDAO;
    @Autowired
    private WorkerDTOFactory workerFactory;
    
    /**
     * Save worker to db
     *
     * @param workerDTO the worker dto
     */
    @Transactional
    public void saveWorker(WorkerDTO workerDTO) {
       workerDAO.addWorker(workerFactory.createModel(workerDTO));
    }
 
    /**
     * Edits the worker in db
     *
     * @param workerDTO the worker dto
     */
    @Transactional
    public void editWorker(WorkerDTO workerDTO) {
    	workerDAO.updateWorker(workerFactory.createModel(workerDTO));
    }
 
    /**
     *  get list of all Workers from db
     *
     * @return the list
     */
    @Transactional
    public List<WorkerDTO> getWorkers() {
    	List<Worker> workers = workerDAO.listWorkers();
    	return workerFactory.createDTOs(workers);
    }
    
    /**
     * Gets the worker with specified id
     *
     * @param workerId the worker id
     * @return the worker
     */
    @Transactional
    public WorkerDTO getWorker(int workerId) {
    	Worker worker = workerDAO.getWorkerById(workerId);
        return workerFactory.createDTO(worker);
    }
    
    /**
     * Delete worker by id from db
     *
     * @param workerId the worker id
     */
    @Transactional
    public void deleteWorker(int workerId) {
        this.workerDAO.removeWorker(workerId);
    }
 
}