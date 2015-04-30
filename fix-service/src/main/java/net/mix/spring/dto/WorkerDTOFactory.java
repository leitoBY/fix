package net.mix.spring.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.mix.spring.model.Worker;
import net.mix.spring.service.DepartmentService;

/**
 * A factory for creating WorkerDTO objects.
 */
@Component
public class WorkerDTOFactory {
	
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@Autowired
	private DepartmentDTOFactory departmentFactory;

	
	/**
	 * Creates a new WorkerDTO object.
	 *
	 * @param worker the worker
	 * @return the worker dto
	 */
	public WorkerDTO createDTO(Worker worker) {
		WorkerDTO dto = new WorkerDTO();
		
		dto.setId(worker.getId());
		dto.setFirstName(worker.getFirstName());
		dto.setLastName(worker.getLastName());
		dto.setSalary(worker.getSalary());
		dto.setDept_id(worker.getDepartment().getDept_id());
		
		return dto;
	}
	
	/**
	 * Creates a new WorkerDTO object.
	 *
	 * @param workers the workers
	 * @return the list< worker dt o>
	 */
	public List<WorkerDTO> createDTOs(List<Worker> workers){
		
		List<WorkerDTO> workerDTOs = new ArrayList<WorkerDTO>();
		
		if (workers != null) {			
			
			for (Worker w : workers) {
				
				WorkerDTO workerDTO = new WorkerDTO();
				workerDTO.setId(w.getId());
				workerDTO.setFirstName(w.getFirstName());
				workerDTO.setLastName(w.getLastName());
				workerDTO.setSalary(w.getSalary());
				workerDTO.setDept_id(w.getDepartment().getDept_id());
				
				
				
				workerDTOs.add(workerDTO);
			}			
		}
		
		return workerDTOs;
	
	}
	
	/**
	 * Creates a new WorkerDTO object.
	 *
	 * @param dto the dto
	 * @return the worker
	 */
	public Worker createModel(WorkerDTO dto) {
		
		Worker model = new Worker();
		model.setId(dto.getId());
		model.setFirstName(dto.getFirstName());
		model.setLastName(dto.getLastName());
		model.setSalary(dto.getSalary());
		model.setDepartment(departmentFactory.createModel(departmentService.getDep(dto.getDept_id())));
		
		return model;
		
	}

	
}
