package net.mix.spring;

import net.mix.spring.dto.DepartmentDTO;
import net.mix.spring.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * The Class DepartmentController.
 * handle requests
 */
@Controller
public class DepartmentController {

	
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * Generate list of all departments
	 *
	 * @param model the model
	 * go to department.jsp
	 */
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String listDeps(Model model) {
				
        model.addAttribute("department", new DepartmentDTO());
        model.addAttribute("listDeps", this.departmentService.viewsList());
        return "department";
    }
     
     /**
     * Save department.
     *
     * @param dep the dep
     * redirect to /departments
     */
    @RequestMapping(value= "/department/add", method = RequestMethod.POST)
    public String saveDep(@ModelAttribute("department") DepartmentDTO dep){
         
        if(dep.getDepartmentId() == 0){
            //new department, add it
            this.departmentService.saveDep(dep);
        }else{
            //existing department, call update
            this.departmentService.editDep(dep);
        }
         
        return "redirect:/departments";
         
    }
     
    /**
     * Delete dep.
     *
     * @param departmentId the department id
     * redirect to /departments
     */
    @RequestMapping("department/remove/{departmentId}")
    public String deleteDep(@PathVariable("departmentId") int departmentId){
         
        this.departmentService.deleteDep(departmentId);
        return "redirect:/departments";
    }
  
    /**
     * Edits the dep.
     *
     * @param departmentId the department id
     * @param model the model
     * go to department.jsp
     */
    @RequestMapping("department/edit/{departmentId}")
    public String editDep(@PathVariable("departmentId") int departmentId, Model model){
        model.addAttribute("department", this.departmentService.getDepartment(departmentId));
        model.addAttribute("listDeps", this.departmentService.viewsList());
        return "department";
    }
	
	
}
