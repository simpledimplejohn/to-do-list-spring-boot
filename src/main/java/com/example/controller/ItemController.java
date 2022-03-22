package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Item;
import com.example.service.ItemService;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {
	
	@Autowired
	ItemService itemServ;
	
	
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
	

}
