package sk.filiptvrdon.firstspringwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<TodoItem> todoItems = new ArrayList<>();

    private static long lastTodoItemId = 0;

    static {
	todoItems.add(new TodoItem(++lastTodoItemId, "Filip", "Learn AWS", LocalDate.now().plusYears(1), false));
	todoItems.add(
		new TodoItem(++lastTodoItemId, "Filip", "Learn DevOps", LocalDate.now().plusYears(2), false));
	todoItems
		.add(new TodoItem(++lastTodoItemId, "Filip", "Learn Azure", LocalDate.now().plusYears(3), false));
    }

    public List<TodoItem> getTodosByUsername(String username) {
	return todoItems.stream().filter(todo -> todo.getUsername().equals(username)).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate) {
	todoItems.add(new TodoItem(++lastTodoItemId, username, description, targetDate, false));
    }

    public void deleteTodoById(long id) {
	todoItems.removeIf(todo -> todo.getId() == id);
    }

    public TodoItem getTodoItemById(long id) {
	return todoItems.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }

    public void updateTodoItem(TodoItem todo) {
	deleteTodoById(todo.getId());
	todoItems.add(todo);
    }
    
    

}
