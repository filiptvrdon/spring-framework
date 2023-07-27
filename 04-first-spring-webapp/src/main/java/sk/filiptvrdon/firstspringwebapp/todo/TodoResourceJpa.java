package sk.filiptvrdon.firstspringwebapp.todo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResourceJpa {

    private TodoService todoService;
    private TodoRepository todoRepository;

    public TodoResourceJpa(TodoService todoService, TodoRepository todoRepository) {
	this.todoService = todoService;
	this.todoRepository = todoRepository;
    }

    
    @GetMapping("/users/{username}/todos")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<TodoItem> getTodosByUsername(@PathVariable String username) {
	// return todoService.getTodosByUsername(username);
	return todoRepository.findByUsername(username);
	
    }
    
    @PostMapping("/users/{username}/todos")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> addTodo(@PathVariable String username, 
	    @RequestBody TodoItem todo) {
	// todoService.addTodo(username, todo.getDescription(), todo.getTargetDate());
	todo.setId(null);
	todo.setUsername(username);
	todoRepository.save(todo);
	return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{username}/todos/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public TodoItem getTodoByID(@PathVariable String username, @PathVariable int id) {
	// return todoService.getTodoItemById(id);
	var optional = todoRepository.findById(id);
	if (optional.isEmpty()) {
	    return null;
	}
	return optional.get();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> deleteTodoByID(@PathVariable String username, @PathVariable int id) {
	// todoService.deleteTodoById(id);
	todoRepository.deleteById(id);
	return ResponseEntity.noContent().build();

    }

    @PutMapping("/users/{username}/todos/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public TodoItem updateTodoByID(@PathVariable String username, @PathVariable int id,
	    @RequestBody TodoItem todo) {
	// todoService.updateTodoItem(todo);
	// deleteTodoByID(username, todo.getId());
	todoRepository.save(todo);
	return todo;

    }
    
   
}
