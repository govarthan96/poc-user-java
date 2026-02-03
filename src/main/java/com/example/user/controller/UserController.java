package com.example.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.UserService.UserService;
import com.example.user.entity.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {


private final UserService service;


public UserController(UserService service) {
this.service = service;
}


@GetMapping
public List<User> getAllUsers() {
	
	 List<User> users = service.getAllUsers();  
	    return users;
}


@PostMapping
public User createUser(@RequestBody User user) {
return service.saveUser(user);
}


@GetMapping("/{id}")
public User getUser(@PathVariable Long id) {
return service.getUserById(id);
}


@DeleteMapping("/{id}")
public String deleteUser(@PathVariable Long id) {
service.deleteUser(id);
return "User deleted";
}

@PutMapping("/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User user) {
    return service.updateUser(id, user);
}
}
