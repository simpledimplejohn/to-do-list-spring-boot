package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.ToDoListRepository;
import com.example.model.ToDoList;

@Service
public class ToDoService {
	
	@Autowired
	ToDoListRepository toDoRepo;
	
	public List<ToDoList> findAll() {
		return toDoRepo.findAll();
	}
	
	public ToDoList addToDoList(ToDoList toDoList) {
		return toDoRepo.save(toDoList);
	}
	
	public List<ToDoList> findToDoListOfUser(int id) {
		return toDoRepo.findAllByUser(id);
	}
	
	public ToDoList findById(int id) {
		return toDoRepo.getById(id);
	}
	
	public void removeToDoList(int id) {
		toDoRepo.deleteById(id);
	}
	
}
