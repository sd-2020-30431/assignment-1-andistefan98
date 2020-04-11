package com.wasteless.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wasteless.data.entity.GroceryList;
import com.wasteless.data.entity.User;
import com.wasteless.data.repository.GroceryListRepository;
import com.wasteless.data.repository.UserRepository;

@Service
public class UserService {
		
	@Autowired
    private  UserRepository userRepository ;
	
	public UserService(UserRepository userRepo) {
		this.userRepository = userRepo;
	}
	
	public List<User> getAllUsers(){
		List<User> myUsers = new ArrayList<User>();
		if(userRepository.findAll()!=null)
		userRepository.findAll().forEach(myUsers::add);		
		return myUsers;
		
	}

	
	public Optional<User> getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}
	
	
	public void addUser(User user) {
		if(userRepository == null) {
			System.out.println("E NULLLLLLl");
		}
	
		userRepository.save(user);
		
	}
	
	public void deleteUser(String username) {
	    userRepository.deleteById(username);
	}

}
