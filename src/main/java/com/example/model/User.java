package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // for network issues
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fristName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	@OneToMany(mappedBy = "user",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JsonManagedReference
	private List<ToDoList> listOfList;
	
	
	public User(String fristName, String lastName, String userName, String email, String password,
			List<ToDoList> listOfList) {
		super();
		this.fristName = fristName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.listOfList = listOfList;
	}
	
	

}
