package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // for network issues
public class Item {
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dateCreated;
	private String description;
	private boolean completed;
	@ManyToOne()
	@JoinColumn(name="to_do_list_id")
	@JsonBackReference
	private ToDoList toDoList;
	public Item(String dateCreated, String description, boolean completed, ToDoList toDoList) {
		super();
		this.dateCreated = dateCreated;
		this.description = description;
		this.completed = completed;
		this.toDoList = toDoList;
	}
	
	

	
	
}
