package sk.filiptvrdon.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

public class UserResource {
    private UserDaoService service;

    public UserResource(UserDaoService service) {
	this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
	return service.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUserByID(@PathVariable long id) {

	User user = service.findById(id);

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

	User savedUser = service.createUser(user);

	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
		.toUri();

	return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
	service.deleteById(id);

    }

}