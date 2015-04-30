package net.mix.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class appController {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String app() {
        
		return "main";
    }
	
}
