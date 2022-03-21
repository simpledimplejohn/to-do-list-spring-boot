package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.ToDoService;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	UserService userServ;
	
	@Autowired
	ToDoService toDoServ;
	
	@GetMapping("/")
	public List<User> findAll() {
		return userServ.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User findUserById(@PathVariable("id") int id) {
		return userServ.getByUserId(id);
	}
	
	@PostMapping("/find")
	public User findUserByEmailAndPassWord(@RequestBody User user) {
		
		return userServ.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		
	}
	
	@PostMapping("/add")
	public int addUser(@RequestBody User user) { 
		return  userServ.addUser(user).getId();
		
	}
	
	@GetMapping("/find/{email}")
	public User findUserByEmail(@PathVariable("email") String email) {
		
		return userServ.findUserByEmail(email);
	}
	
	@PutMapping("/{id}")
	public User updateUserById(@RequestBody User user) {
		
		System.out.println(user);

		return userServ.addUser(user);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id") int id) {
		
		 userServ.deleteUser(id);
	}
	

}
