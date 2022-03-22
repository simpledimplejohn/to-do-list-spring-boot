package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Item;
import com.example.model.ToDoList;
import com.example.service.ItemService;
import com.example.service.ToDoService;
import com.example.service.UserService;

@RestController
@RequestMapping("/lists")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ListController {
	
	@Autowired
	UserService userServ;
	@Autowired
	ToDoService toDoServ;
	@Autowired
	ItemService itemServ;
	
	@GetMapping("/")
	public List<ToDoList> findAll() {
		return toDoServ.findAll();
	}
	
	@GetMapping("/{id}")
	public ToDoList findToDoListById(@PathVariable("id") int id) {
		return toDoServ.findById(id);
	}
	
	@GetMapping("/{id}/itemList")
	public List<Item> findItemByListId(@PathVariable("id") int id) {
		ToDoList toDoList = toDoServ.findById(id);
		return toDoList.getTaskList();
		
	}
	
	@PutMapping("/{id}/add")
	public Item addItemToList(@PathVariable("id") int id, @RequestBody Item item) {
		ToDoList toDoList = toDoServ.findById(id);
		item.setToDoList(toDoList);
		itemServ.addItem(item);
		return item;
	}
	@DeleteMapping("/delete/{id}")
	public void deleteItem(@PathVariable("id") int id) {
		itemServ.removeItem(id);
	}

}
