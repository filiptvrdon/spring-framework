package sk.filiptvrdon.firstspringwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
    
    private TodoService todoService;
    // private Logger logger = LoggerFactory.getLogger(getClass());
    
    
    public TodoController(TodoService todoService) {
	super();
	this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
	List<TodoItem> todos = todoService.getTodosByUsername(getLoggedInUserName());
	model.put("todos", todos);
	return "todoList";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String displayAddTodoPage(ModelMap model) {
	TodoItem todo = new TodoItem(0,getLoggedInUserName(),"",LocalDate.now(),false);
	model.put("todo", todo);
	return "todo";
    }
    
    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String processNewTodoAndRedirectToList(ModelMap model, @Valid TodoItem todo, BindingResult result) {
	if (result.hasErrors()) {
	    model.put("todo", todo);
	    return "todo";
	}
	todoService.addTodo(getLoggedInUserName(), todo.getDescription(), todo.getTargetDate());
	return "redirect:list-todos";
    }
    
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam long id) {
	todoService.deleteTodoById(id);
	return "redirect:list-todos";
    }
    
    @RequestMapping(value="edit-todo", method = RequestMethod.GET)
    public String displayEditTodo(@RequestParam long id, ModelMap model) {
	TodoItem todo = todoService.getTodoItemById(id);
	model.addAttribute("todo", todo);
	return "todo";
    }
    
    @RequestMapping(value="edit-todo", method = RequestMethod.POST)
    public String processEditTodoAndRedirectToList(ModelMap model, @Valid TodoItem todo, BindingResult result) {
	if (result.hasErrors()) {
	    model.put("todo", todo);
	    return "todo";
	}
	todoService.updateTodoItem(todo);
	model.addAttribute("todo", todo);
	return "redirect:list-todos";
    }
    
    private String getLoggedInUserName() {
	return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
