package com.example.easygrocerylists.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;

@Repository
public interface ItemRepository extends JpaRepository<GroceryItem , Integer>{
	
	public GroceryItem findById(int id);
	
	public List<GroceryItem> findByList(GroceryList list);
	
    public List<GroceryItem> findAll();

}
