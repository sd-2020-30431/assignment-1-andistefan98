package com.wasteless.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.GroceryList;

@Repository
public interface ItemRepository extends JpaRepository<GroceryItem , Integer>{
	
	public GroceryItem findById(int id);
	
	public List<GroceryItem> findByList(GroceryList listId);
	
    public List<GroceryItem> findAll();
   
}
