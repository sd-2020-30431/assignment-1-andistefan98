package com.example.easygrocerylists.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String username;
	@Column
	String password;
	@Column
	int caloricGoal ;
	
	@OneToMany
	@JoinColumn(name = "lists")
	List<GroceryList> groceryLists = new ArrayList<GroceryList>();
	
	
	public int getCaloricGoal() {
		return caloricGoal;
	}
	
	
	public void setCaloricGoal(int caloricGoal) {
		this.caloricGoal = caloricGoal;
	}


	public List<GroceryList> getGroceryLists() {
		return groceryLists;
	}


	public void setGroceryLists(List<GroceryList> groceryLists) {
		this.groceryLists = groceryLists;
	}
	
	
	
	
}