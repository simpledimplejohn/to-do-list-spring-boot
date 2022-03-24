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

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {
	
	@Autowired
	ItemService itemServ;
	
	@Autowired
	ToDoService listServ;
	
	
	@GetMapping("/")
	public List<Item> findAll() {
		return itemServ.findAll();
	}
	
	@GetMapping("/{id}")
	public Item findById(@PathVariable("id") int id) {
		return itemServ.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteItemById(@PathVariable("id") int id) {
		itemServ.removeItem(id);
	}
	
	@PutMapping("/{lid}/add/")
	public Item addItemToListById(@PathVariable("lid") int lid, @RequestBody Item item) {
		ToDoList toDo = listServ.findById(lid);
		item.setToDoList(toDo);
		return itemServ.addItem(item);
		
	}
	

}
