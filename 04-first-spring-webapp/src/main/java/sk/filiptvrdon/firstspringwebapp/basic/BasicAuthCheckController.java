package sk.filiptvrdon.firstspringwebapp.basic;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuthCheckController {

    @GetMapping("/basicauth")
    @CrossOrigin(origins = "http://localhost:3000")
    public String basicAuthCheck() {
	return "Sucess";
    }
    
    

}
