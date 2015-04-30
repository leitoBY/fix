package net.mix.spring;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 





import net.mix.spring.dto.WorkerDTO;
import net.mix.spring.service.DepartmentService;
import net.mix.spring.service.WorkerService;
 
@Controller
public class DepworkerController {
     
    @Autowired
    private WorkerService workerService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "depworkers/{id}",  method = RequestMethod.GET)
	
	public String listWorker(@PathVariable("id") int id, Model model) {
	model.addAttribute("workerDTO", new WorkerDTO());
    model.addAttribute("listWorkers", this.workerService.listWorkers());
    model.addAttribute("department", this.departmentService.getDep(id));
    return "depworker";
    }
 
     
    //For add and update person both
    @RequestMapping(value="/depworkers/{id}/add", method = RequestMethod.POST)
    public String saveDepworker(@PathVariable("id") int id, @ModelAttribute("workerDTO") WorkerDTO w){
         
        if(w.getId() == 0){
            //new person, add it
            this.workerService.saveWorker(w);
        }else{
            //existing person, call update
            this.workerService.editWorker(w);
        }
         
        return "redirect:/depworkers/{id}";
         
    }
     
    @RequestMapping(value = "/depworkers/{id}/remove/{workerid}")
    public String deleteDepworker(@PathVariable("id") int id, @PathVariable("workerid") int workerid){
         
        this.workerService.deleteWorker(workerid);;
        return "redirect:/depworkers/{id}";
    }
  
    @RequestMapping(value = "/depworkers/{id}/edit/{workerid}")
    public String editDepworker(@PathVariable("workerid") int workerid, @PathVariable("id") int id, Model model){
        model.addAttribute("workerDTO", this.workerService.getWorker(workerid));
        model.addAttribute("listWorkers", this.workerService.listWorkers());
        model.addAttribute("department", this.departmentService.getDep(id));
        return "depworker";
    }
    

}