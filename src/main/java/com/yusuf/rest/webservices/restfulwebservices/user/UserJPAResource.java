package com.yusuf.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class UserJPAResource {
	
	@Autowired
	private UserDaoService service;
	
	@Autowired
	private UserRepository userRepository;
	
	// GET /users
	// retrieveAllUsers - retrieve all users
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	// GET /users/{id}
	// retrieveUser(int id) - retrieve a single user
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		// Throw a runtime error exception if the user does not exist
		if (user.isPresent()) {
			throw new UserNotFoundException("User with id "+id+ " cannot be found!");
		}
		
		EntityModel<User> model = new EntityModel<User>(user.get());
		
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		model.add(linkToUsers.withRel("all-users"));
		
		return model;
	}
	
	// POST /users
	// insertUser - insert a user to the list
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> insertUser(@Valid @RequestBody User user) {
		User insertedUser = service.save(user);
		
		// provide the location of the newly created user in the form of URI
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(insertedUser.getId())
			.toUri();
		
		// Send the created status code
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if (user == null) {
			throw new UserNotFoundException("id-"+id);
		}
	}
}
