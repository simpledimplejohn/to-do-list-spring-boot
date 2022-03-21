package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.UserRepository;
import com.example.model.User;

@Service
public class UserService {
	@Autowired
	public
	UserRepository userRepo;
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User getByUserId(int id){
		
		User  user = userRepo.getById(id);
		return user;
	}
	
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}
	
	public User findUserByEmailAndPassWord(String email , String passWord) {
		 
		User user = userRepo.findByEmailAndPassWord(email, passWord).get(0);
		
		return user;
	}
	
	
	public User findUserByEmail(String email) {
		return  userRepo.findByEmail(email).get(0);
				
	}
}
