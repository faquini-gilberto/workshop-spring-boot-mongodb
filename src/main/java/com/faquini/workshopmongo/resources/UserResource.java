package com.faquini.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faquini.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	// public List<User> findAll() {
	public ResponseEntity<List<User>> findAll() {
		List<User> list = new ArrayList<>();
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User bob = new User("2", "Bob Green", "bob@gmail.com");
		list.addAll(Arrays.asList(maria, bob));
		return ResponseEntity.ok().body(list);
	}

}
