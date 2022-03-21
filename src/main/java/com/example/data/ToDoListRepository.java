package com.example.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ToDoList;



@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Integer>{
	
	List<ToDoList> findAllByUser(int userId);
	
}
