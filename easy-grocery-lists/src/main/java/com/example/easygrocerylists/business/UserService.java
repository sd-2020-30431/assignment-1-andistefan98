package com.example.easygrocerylists.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easygrocerylists.data.entity.GroceryList;
import com.example.easygrocerylists.data.entity.User;
import com.example.easygrocerylists.data.repository.GroceryListRepository;
import com.example.easygrocerylists.data.repository.UserRepository;

@Service
public class UserService {
		
	@Autowired
    private UserRepository userRepository ;
	
	public List<User> getAllUsers(){
		List<User> myUsers = new ArrayList<User>();
		if(userRepository.findAll()!=null)
		userRepository.findAll().forEach(myUsers::add);		
		return myUsers;
		
	}
	
/*	
	public User getUserById(int id){
		return userRepository.getUserById(id);
	}*/
	
	public Optional<User> getUserByUsername(String username) {
		return userRepository.findById(username);
	}
	
	
	public void addUser(User user) {
		userRepository.save(user);
		
	}
	
	public void deleteUser(String username) {
	    userRepository.deleteById(username);
	}

}
