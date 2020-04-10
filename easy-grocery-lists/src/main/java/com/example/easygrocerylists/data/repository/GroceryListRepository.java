package com.example.easygrocerylists.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;
import com.example.easygrocerylists.data.entity.User;

@Repository
public interface GroceryListRepository extends JpaRepository<GroceryList , Integer>{
	
	public List<GroceryList> findAll();
	
	public List<GroceryList> getAllByUserId(User userId);



}

