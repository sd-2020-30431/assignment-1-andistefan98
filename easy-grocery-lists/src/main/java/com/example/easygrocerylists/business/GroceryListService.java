package com.example.easygrocerylists.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.easygrocerylists.data.entity.GroceryList;
import com.example.easygrocerylists.data.repository.GroceryListRepository;
//import javax.inject.Inject;

import com.example.easygrocerylists.data.repository.GroceryListRepository;

@Service
public class GroceryListService {
	
	@Autowired
	private GroceryListRepository listRepository ;
	
	public List<GroceryList> getAllLists(){
		List<GroceryList> myLists = new ArrayList<GroceryList>();
		listRepository.findAll().forEach(myLists::add);
		
		return myLists;
		
	}
	
	
	public void addList(GroceryList lst) {
		listRepository.save(lst);
		
	}
	
	public void deleteList(int id) {
	    listRepository.deleteById(id);
	}
	

}
