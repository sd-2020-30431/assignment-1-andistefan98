package com.example.easygrocerylists.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;
import com.example.easygrocerylists.data.repository.GroceryListRepository;
import com.example.easygrocerylists.data.repository.ItemRepository;

@Service
public class GroceryItemService {
	
	@Autowired
	private ItemRepository itemRepository ;
	
	public List<GroceryItem> getAllItems(){
		List<GroceryItem> myList = new ArrayList<GroceryItem>();
		itemRepository.findAll().forEach(myList::add);
		
		return myList;
		
	}
	
	public GroceryItem findById(int id) {
		return itemRepository.findById(id);
	}
	
	public List<GroceryItem> findByList(GroceryList list){
		return itemRepository.findByList(list);
	}
	
	
	public void addItem(GroceryItem itm) {
		itemRepository.save(itm);
		
	}
	
	public void deleteItem(int id) {
	    itemRepository.deleteById(id);
	}

}
