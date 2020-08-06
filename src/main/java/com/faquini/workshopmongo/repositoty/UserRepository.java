package com.faquini.workshopmongo.repositoty;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.faquini.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
