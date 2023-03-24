package com.example.server.controller;

import com.example.server.repository.ServerRepository;
import com.example.server.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ServerController{
    
    // autowired with our ServerRepository instantiates a mongodbDB for us to use
    @Autowired
    private ServerRepository repository;
    
    // standard 404 response
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {
    }
   
    // returns all the server objects as JSON
    @GetMapping
    public List<Server> returnAllServers(){
        return repository.findAll();
    }
    
    // returns the server of the id
    @GetMapping("{id}")
    public Optional<Server> returnById(@PathVariable String id){
        Server s = repository.findById(id).orElse(null   );
        if (s == null) throw new ResourceNotFoundException();
        return repository.findById(id);
    }
    
    // returns server objects with the name in it
    @GetMapping("name/{name}")
    public List<Server> returnByName(@PathVariable String name){
        List<Server> s = new ArrayList<Server>();
        for(Server temp: repository.findAll()){
            if(temp.name().contains(name)){
                s.add(temp);
            }
        }
        if (s.isEmpty()){
            throw new ResourceNotFoundException();
        }
        return s;
    }
    
    // takes in server objects as JSON
    @PostMapping
    public ResponseEntity<?> saveByJSON(@RequestBody Server server){
        repository.save(server);
        return new ResponseEntity<>("Server Added Successfully", HttpStatus.OK);
    }
    
    // deletes server based on ID given
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        repository.deleteById(id);
        return new ResponseEntity<>("Server Deleted Successfully", HttpStatus.OK);
    }
}
