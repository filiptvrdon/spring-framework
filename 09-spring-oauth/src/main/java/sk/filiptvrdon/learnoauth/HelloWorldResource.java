package sk.filiptvrdon.learnoauth;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
    @GetMapping("/")
    public String helloWorld(Authentication auth) {
	System.out.println(auth);
	return "Hello World!";
    }

}
