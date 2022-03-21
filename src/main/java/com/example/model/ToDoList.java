package com.example.model;

import java.util.List;

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
@Table(name="to_do_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // for network issues
public class ToDoList {
	@Id
	@Column(name="to_do_list_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String listName;
	private String date;
	private boolean complete;
	@ManyToOne()
	@JoinColumn(name="user_id")
	@JsonBackReference
	private User user;
	private List<Item> taskList;
	public ToDoList(String listName, String date, boolean complete, User user, List<Item> taskList) {
		super();
		this.listName = listName;
		this.date = date;
		this.complete = complete;
		this.user = user;
		this.taskList = taskList;
	}
	
	
}
