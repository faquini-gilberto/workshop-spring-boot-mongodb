package com.faquini.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faquini.workshopmongo.domain.User;
import com.faquini.workshopmongo.repositoty.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
	
		return repo.findAll();
	}

}
