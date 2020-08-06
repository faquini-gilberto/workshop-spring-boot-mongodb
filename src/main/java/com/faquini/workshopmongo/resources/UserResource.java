package com.faquini.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faquini.workshopmongo.domain.User;
import com.faquini.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	// public List<User> findAll() {
	public ResponseEntity<List<User>> findAll() {
		// List<User> list = new ArrayList<>();
		// User maria = new User("1", "Maria Brown", "maria@gmail.com");
		// User bob = new User("2", "Bob Green", "bob@gmail.com");
		// list.addAll(Arrays.asList(maria, bob));
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
