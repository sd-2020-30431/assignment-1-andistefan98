package com.example.easygrocerylists.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;

public interface GroceryListRepository extends CrudRepository<GroceryList , Integer>{
	
	//public List<GroceryList> findAllByUserId(int id);

}

