package com.hunue.controllers;


import com.hunue.entities.User;
import com.hunue.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    UserService userService;


        @GetMapping("/test")
        public String index() {
            return "Hola mundo.";
        }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<String> add(@RequestBody User user){
        userService.add(user);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id){
            userService.delete(id);
           return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> update(@PathVariable Long id, @RequestBody User user){
        userService.update(id,user);
        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }




}
