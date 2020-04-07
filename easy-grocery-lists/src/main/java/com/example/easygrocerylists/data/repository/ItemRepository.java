package com.example.easygrocerylists.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.easygrocerylists.data.entity.GroceryItem;

public interface ItemRepository extends CrudRepository<GroceryItem , Integer>{
	
	public List<GroceryItem> findAllByGroceryListId(int id);

}
