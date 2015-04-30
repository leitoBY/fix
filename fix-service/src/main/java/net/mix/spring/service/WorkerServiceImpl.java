package net.mix.spring.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.mix.spring.dao.WorkerDAO;
import net.mix.spring.dto.WorkerDTO;
import net.mix.spring.dto.WorkerDTOFactory;
import net.mix.spring.model.Worker;
 
@Service
public class WorkerServiceImpl implements WorkerService {
     
    @Autowired
	private WorkerDAO workerDAO;
    @Autowired
    private WorkerDTOFactory workerFactory;
 
   
    @Transactional
    public void saveWorker(WorkerDTO workerDTO) {
        
    	workerDAO.addWorker(workerFactory.createModel(workerDTO));
    }
 
    
    @Transactional
    public void editWorker(WorkerDTO workerDTO) {
    	
        workerDAO.updateWorker(workerFactory.createModel(workerDTO));
    }
 
    
    @Transactional
    public List<WorkerDTO> listWorkers() {
    	
    	List<Worker> workers = workerDAO.listWorkers();
    	return workerFactory.createDTOs(workers);
    }
    
    
    @Transactional
    public WorkerDTO getWorker(int workerId) {
    	
    	Worker worker = workerDAO.getWorkerById(workerId);
        return workerFactory.createDTO(worker);
    }
    
    
    @Transactional
    public void deleteWorker(int workerId) {
        this.workerDAO.removeWorker(workerId);
    }
 
}