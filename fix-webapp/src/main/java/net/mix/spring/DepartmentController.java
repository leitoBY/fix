package net.mix.spring;

import java.util.List;

import net.mix.spring.dto.DepartmentDTO;
import net.mix.spring.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String listDeps(Model model) {
		
		List<DepartmentDTO> list = departmentService.listDeps();
		for(DepartmentDTO d : list) {
		departmentService.countSalary(d);
		}
		
        model.addAttribute("department", new DepartmentDTO());
        model.addAttribute("listDeps", this.departmentService.listDeps());
        return "department";
    }
     
    //For add and update person both
    @RequestMapping(value= "/department/add", method = RequestMethod.POST)
    public String saveDep(@ModelAttribute("department") DepartmentDTO dep){
         
        if(dep.getDept_id() == 0){
            //new person, add it
            this.departmentService.saveDep(dep);
        }else{
            //existing person, call update
            this.departmentService.editDep(dep);
        }
         
        return "redirect:/departments";
         
    }
     
    @RequestMapping("department/remove/{dept_id}")
    public String deleteDep(@PathVariable("dept_id") int dept_id){
         
        this.departmentService.deleteDep(dept_id);
        return "redirect:/departments";
    }
  
    @RequestMapping("department/edit/{dept_id}")
    public String editDep(@PathVariable("dept_id") int dept_id, Model model){
        model.addAttribute("department", this.departmentService.getDep(dept_id));
        model.addAttribute("listDeps", this.departmentService.listDeps());
        return "department";
    }
	
	
}
