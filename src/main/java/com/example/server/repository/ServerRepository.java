package com.example.server.repository;

import com.example.server.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;

// extending the mongodb spring framework with our server objects
public interface ServerRepository extends MongoRepository<Server, String> {}
