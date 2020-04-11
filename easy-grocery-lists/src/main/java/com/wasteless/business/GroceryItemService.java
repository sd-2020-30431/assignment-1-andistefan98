package com.wasteless.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.GroceryList;
import com.wasteless.data.repository.GroceryListRepository;
import com.wasteless.data.repository.ItemRepository;

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
	
	public List<GroceryItem> findByList(GroceryList listId){
		return itemRepository.findByList(listId);
	}
	
	
	public void addItem(GroceryItem itm) {
		itemRepository.save(itm);
		
	}
	
	public void deleteItem(int id) {
	
		GroceryItem itm = itemRepository.findById(id);
		System.out.println( "  ->->  " + itm.getId());

	    itemRepository.deleteById(id);
	   // itemRepository.delete(itm);

	    itemRepository.flush();
	
	}

}
