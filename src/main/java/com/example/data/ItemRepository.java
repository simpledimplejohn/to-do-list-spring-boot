package com.example.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	List<Item> findAllByToDoList(int to_do_list_id);
}
