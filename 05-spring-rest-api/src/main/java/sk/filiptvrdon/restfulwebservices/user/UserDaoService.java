package sk.filiptvrdon.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    private static long lastUserId = 0; 
    private static List<User> users = new ArrayList<>();
    

    static {
	users.add(new User(lastUserId++, "Adam", LocalDate.now().minusYears(30)));
	users.add(new User(lastUserId++, "Eve", LocalDate.now().minusYears(25)));
	users.add(new User(lastUserId++, "Jim", LocalDate.now().minusYears(35)));
    }

    public List<User> findAll() {
	return users;
    }

    public User findById(long id) {
	return users.stream()
		.filter(user -> user.getId() == id)
		.findFirst()
		.orElse(null);
	
    }

    public User createUser(User user) {
	user.setId(lastUserId++);
	users.add(user);
	return user;
    }

    public void deleteById(long id) {
	users.removeIf(user -> user.getId() == id);
    }
    
    
    
    

}
