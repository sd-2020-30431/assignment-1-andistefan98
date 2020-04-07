package com.example.easygrocerylists.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.User;

public interface UserRepository extends JpaRepository<User , String>{

//	public User getUserByUsername(String username);

	//public void delete(String username);
	
	
	//public void deleteById(int id);
}
