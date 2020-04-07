package com.example.easygrocerylists.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;

public interface GroceryListRepository extends JpaRepository<GroceryList , Integer>{
	
	public List<GroceryList> findAll();
	
	public List<GroceryList> getAllByUserId(int id);

}

