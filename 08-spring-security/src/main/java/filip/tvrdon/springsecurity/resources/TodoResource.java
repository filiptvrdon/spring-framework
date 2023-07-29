package filip.tvrdon.springsecurity.resources;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableMethodSecurity
public class TodoResource {

    private static List<Todo> todosList = new ArrayList<>();
    {
	todosList.add(new Todo("in28minutes", "Learn AWS"));
	todosList.add(new Todo("in28minutes", "Get AWS Certified"));
	todosList.add(new Todo("in28minutes", "Learn Google Cloud"));
	todosList.add(new Todo("in28minutes", "Learn Azure"));
	todosList.add(new Todo("in28minutes", "Learn React"));
    }
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/todos")
    public List<Todo> getTodos() {
	return todosList;
    }

    @GetMapping("/users/{username}/todos")
    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    public List<Todo> getTodosByUsername(@PathVariable String username) {
	return todosList.subList(0, 3);
    }
    
    
    @PostMapping("/users/{username}/todos")
    public void createTodoForUsername(@PathVariable String username, @RequestBody Todo todo) {
	logger.info("Creating {} for {}", todo, username);
	todosList.add(todo);
	
    }

}

record Todo(String username, String description) {
}