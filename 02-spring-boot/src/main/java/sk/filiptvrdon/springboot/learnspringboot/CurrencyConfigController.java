package sk.filiptvrdon.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// create a rest api to return course data


@RestController
public class CurrencyConfigController {
    
    @Autowired
    private CurrencyServiceConfiguration currencyServiceConfiguration;
    
    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveAllCourses(){
	return currencyServiceConfiguration;
    }
    

}
