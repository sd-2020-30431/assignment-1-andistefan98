package com.example.easygrocerylists.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="lists")
public class GroceryList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String listName;
	
	@OneToMany
	@JoinColumn(name="items")
	List<GroceryItem> items = new ArrayList<GroceryItem>();
	
	
	@ManyToOne
	@JoinColumn(name="users")
	User userHavingList ;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	
	public List<GroceryItem> getItems() {
		return items;
	}

	public void setItems(List<GroceryItem> items) {
		this.items = items;
	}

	public GroceryList() {
		
	}

	public User getUserHavingList() {
		return userHavingList;
	}

	public void setUserHavingList(User userHavingList) {
		this.userHavingList = userHavingList;
	}
	
	
	
}
