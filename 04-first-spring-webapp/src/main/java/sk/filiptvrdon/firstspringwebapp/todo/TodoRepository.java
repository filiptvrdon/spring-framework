package sk.filiptvrdon.firstspringwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoItem, Integer> {
    
    List<TodoItem> findByUsername(String username);
    

}
