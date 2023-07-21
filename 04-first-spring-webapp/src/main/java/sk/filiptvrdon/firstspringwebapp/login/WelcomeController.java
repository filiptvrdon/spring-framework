package sk.filiptvrdon.firstspringwebapp.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
    
    	
    	@RequestMapping(value="/", method = RequestMethod.GET) // by default this is handling both GET and POST
	public String goToWelcomePage(ModelMap model) {
    	    	model.put("name", getLoggedInUserName());
		return "welcome";
	}
    	
    	private String getLoggedInUserName() {
    	    return SecurityContextHolder.getContext().getAuthentication().getName();
    	}


}
