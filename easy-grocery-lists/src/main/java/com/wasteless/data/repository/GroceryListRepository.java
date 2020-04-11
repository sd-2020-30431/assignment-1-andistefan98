package com.wasteless.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.GroceryList;
import com.wasteless.data.entity.User;

@Repository
public interface GroceryListRepository extends JpaRepository<GroceryList , Integer>{
	
	public List<GroceryList> findAll();
	
	public List<GroceryList> getAllByUserId(User userId);



}

