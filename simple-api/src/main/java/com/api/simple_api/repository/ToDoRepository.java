package com.api.simple_api.repository;

import com.api.simple_api.data.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> { }
