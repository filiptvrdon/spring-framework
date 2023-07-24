package sk.filiptvrdon.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import sk.filiptvrdon.restfulwebservices.jpa.PostRepository;
import sk.filiptvrdon.restfulwebservices.jpa.UserRepository;

@RestController
public class UserJpaResource {
    private UserRepository repository;
    private PostRepository postRepository;

    public UserJpaResource(UserDaoService service, UserRepository repository, PostRepository postRepository) {
	this.repository = repository;
	this.postRepository = postRepository;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
	// return service.findAll();
	return repository.findAll();

    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUserByID(@PathVariable long id) {

	// User user = service.findById(id);
	Optional<User> optionalUser = repository.findById((int) id);

	if (optionalUser.isEmpty()) {
	    throw new UserNotFoundException(null);
	}

	User user = optionalUser.get();

	if (user == null) {
	    throw new UserNotFoundException("id:" + id);
	}

	WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
	EntityModel<User> entityModel = EntityModel.of(user);
	entityModel.add(link.withRel("all-users"));

	return entityModel;

    }

    /*
     * @PostMapping("users") public ResponseEntity<User> createUser(@RequestBody
     * User user) { service.createUser(user);
     * 
     * return ResponseEntity.created(null).build(); }
     */

    // return a link to GET the new user //
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

	// User savedUser = service.createUser(user);
	User savedUser = repository.save(user);

	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
		.toUri();

	return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
	repository.deleteById((int) id);

    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
	Optional<User> user = repository.findById(id);

	if (user.isEmpty()) {
	    throw new UserNotFoundException("User not found");
	}

	return user.get().getPosts();
    }

    @PostMapping("users/{user_id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int user_id, @Valid @RequestBody Post post) {
	Optional<User> userOptional = repository.findById(user_id);

	if (userOptional.isEmpty()) {
	    throw new UserNotFoundException(null);
	}

	post.setUser(userOptional.get());
	Post savedPost = postRepository.save(post);

	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
		.toUri();

	return ResponseEntity.created(location).build();

    }

}