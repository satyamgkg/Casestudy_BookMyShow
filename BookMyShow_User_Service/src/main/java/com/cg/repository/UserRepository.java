package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cg.model.Users;

public interface UserRepository extends MongoRepository<Users, Integer> {

}
