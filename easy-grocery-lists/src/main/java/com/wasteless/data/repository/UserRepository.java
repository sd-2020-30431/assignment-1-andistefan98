package com.wasteless.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User , String>{

//	public User getUserByUsername(String username);
	
	//public List<User> getAll();
	
	public Optional<User> getUserByUsername(String username);
	
	
	//public void delete(String username);
	
	
	//public void deleteById(int id);
}
