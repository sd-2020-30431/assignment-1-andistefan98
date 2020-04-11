package com.wasteless.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wasteless.data.entity.GroceryList;
import com.wasteless.data.entity.User;
import com.wasteless.data.repository.GroceryListRepository;

@Service
public class GroceryListService {
	
	@Autowired
	private GroceryListRepository listRepository ;
	
	public List<GroceryList> getAllLists(){
		List<GroceryList> myLists = new ArrayList<GroceryList>();
		listRepository.findAll().forEach(myLists::add);
		
		return myLists;
		
	}
	
	
	public List<GroceryList> getAllByUserId(User userId){
		return listRepository.getAllByUserId(userId);
	}
	
	
	public void addList(GroceryList lst) {
		listRepository.save(lst);
		
	}
	
	public void deleteList(int id) {
	    listRepository.deleteById(id);
	}
	

}
