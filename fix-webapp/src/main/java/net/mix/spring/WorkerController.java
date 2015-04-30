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
public class WorkerController {
     
    @Autowired
    private WorkerService workerService;
    @Autowired
    private DepartmentService departmentService;
    
         
    @RequestMapping(value = "/workers", method = RequestMethod.GET)
    public String listWorkers(Model model) {
    	    	
    	
        model.addAttribute("workerDTO", new WorkerDTO());
        model.addAttribute("listWorkers", this.workerService.listWorkers());
        model.addAttribute("listDeps", this.departmentService.listDeps());
        return "worker";
    }
     
    //For add and update person both
    @RequestMapping(value= "/worker/add", method = RequestMethod.POST)
    public String saveWorker(@ModelAttribute("workerDTO") WorkerDTO w){
         
        if(w.getId() == 0){
            //new person, add it
            this.workerService.saveWorker(w);
        }else{
            //existing person, call update
            this.workerService.editWorker(w);
        }
         
        return "redirect:/workers";
         
    }
     
    @RequestMapping("worker/remove/{id}")
    public String deleteWorker(@PathVariable("id") int id){
         
        this.workerService.deleteWorker(id);;
        return "redirect:/workers";
    }
  
    @RequestMapping("worker/edit/{id}")
    public String editWorker(@PathVariable("id") int id, Model model){
        model.addAttribute("workerDTO", this.workerService.getWorker(id));
        model.addAttribute("listWorkers", this.workerService.listWorkers());
        model.addAttribute("listDeps", this.departmentService.listDeps());
        return "worker";
    }
}