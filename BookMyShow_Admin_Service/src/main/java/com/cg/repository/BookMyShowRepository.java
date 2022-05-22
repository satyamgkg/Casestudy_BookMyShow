package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cg.model.BookMyShowAdmin;

public interface BookMyShowRepository extends MongoRepository<BookMyShowAdmin, Integer>  {

}
