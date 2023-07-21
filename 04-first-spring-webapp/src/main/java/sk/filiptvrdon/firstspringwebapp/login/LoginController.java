package sk.filiptvrdon.firstspringwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
    
    	// private Logger logger = LoggerFactory.getLogger(getClass());
    
	/*
	 * @RequestMapping("login") public String getLoginContentJsp(@RequestParam
	 * String name, ModelMap model) { model.put("name", name);
	 * logger.info("Request param is {}", name); return "login"; }
	 */
    
    	@Autowired
    	private AuthenticationService authenticationService;
    	
    	
    	@RequestMapping(value="/", method = RequestMethod.GET) // by default this is handling both GET and POST
	public String getLoginContentJsp(ModelMap model) {
    	    	model.put("name", "Filip");
		return "login";
	}
    	
    	/*
	@RequestMapping(value="login", method = RequestMethod.POST) // by default this is handling both GET and POST
	public String redirectToWelcomePageString(@RequestParam String name, @RequestParam String password, ModelMap model) {
	    	model.put("name", name);
	    	
	    	if(authenticationService.authenticate(name, password)) {
			model.put("name", name);
			return "welcome";
		}
	    	model.put("errorMessage", "Incorrect credentials!");
	    	return "login";
	}
    	*/


}
