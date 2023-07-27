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
public class TodoResource {

    private TodoService todoService;

    public TodoResource(TodoService todoService) {
	this.todoService = todoService;
    }

    @GetMapping("/users/{username}/todos")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<TodoItem> getTodosByUsername(@PathVariable String username) {
	return todoService.getTodosByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public TodoItem getTodoByID(@PathVariable String username, @PathVariable int id) {
	return todoService.getTodoItemById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodoByID(@PathVariable String username, @PathVariable int id) {
	todoService.deleteTodoById(id);
	return ResponseEntity.noContent().build();

    }

    @PutMapping("/users/{username}/todos/{id}")
    public TodoItem updateTodoByID(@PathVariable String username, @PathVariable int id,
	    @RequestBody TodoItem todo) {
	todoService.updateTodoItem(todo);
	return todo;

    }
    
    
    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Object> updateTodoByID(@PathVariable String username, 
	    @RequestBody TodoItem todo) {
	todoService.addTodo(username, todo.getDescription(), todo.getTargetDate());
	return ResponseEntity.noContent().build();
    }
}
