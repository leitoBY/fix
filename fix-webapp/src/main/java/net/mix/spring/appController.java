package net.mix.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * The Class appController.
 */
@Controller
public class appController {

	/**
	 * App
	 * go to main.jsp
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String app() {
        return "main";
    }
	
}
