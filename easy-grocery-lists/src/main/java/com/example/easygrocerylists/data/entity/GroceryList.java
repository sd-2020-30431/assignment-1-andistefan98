package com.example.easygrocerylists.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name="list_id")
	int list_id;
	
	@Column(name="list_name")
	String listName;
	
	
	@OneToMany(mappedBy="list")
	List<GroceryItem> itemsList = new ArrayList<GroceryItem>();
	
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	User userId ;
	
	public GroceryList(String name, User user) {
		this.listName = name;
		this.userId= user;
	}
	
	
	
	public int getId() {
		return list_id;
	}

	public void setId(int id) {
		this.list_id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	
	public List<GroceryItem> getItems() {
		return itemsList;
	}

	public void setItems(List<GroceryItem> items) {
		this.itemsList = items;
	}

	public GroceryList() {
		
	}

	public User getUserHavingList() {
		return userId;
	}

	public void setUserHavingList(User userHavingList) {
		this.userId = userHavingList;
	}
	
	
	
}
