package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.ItemRepository;
import com.example.model.Item;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepo;
	
	public List<Item> findAll() {
		return itemRepo.findAll();
	}
	
	public Item addItem(Item item) {
		return itemRepo.save(item);
	}
	
	// TODO make this connection
	public List<Item> findItemOfToDo(int id) {
		return itemRepo.findAllByToDoList(id);
	}
	
	public Item findById(int id) {
		return itemRepo.getById(id);
	}
	
	public void removeItem(int id) {
		itemRepo.deleteById(id);
	}
}
