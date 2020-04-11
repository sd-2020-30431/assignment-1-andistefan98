package com.wasteless.business;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.GroceryList;
import com.wasteless.data.entity.User;

public class BurnDownRateCalculator {
	
	static float computeBurndownRateOfProduct(GroceryItem item) {
		
		float calories = item.getCalorieValue();
	    int quantity = item.getQuantity() ; 
	    Date expiration = item.getExpirationDate();
	    

       Calendar calendar = Calendar.getInstance();
       int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR); 
       
       LocalDate expirationLocal = convertToLocalDateViaInstant(expiration);
       int dayyExp = expirationLocal.getDayOfYear();
       
       int noOfDays = dayyExp - dayOfYear + 1; 
       
       float burndownRate = (calories * quantity)/noOfDays;
       
       return burndownRate;
       
	
	}
	
	
	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}


	public static String getWasteMessage(Optional<User> user, GroceryListService listServ, UserService service, GroceryItemService itemServ) {
		String message ; 

		  List<GroceryList> usersLists = listServ.getAllByUserId(user.get());
			
			
			List<GroceryItem> itemsOfUser = new ArrayList<GroceryItem>();
			
		 for(GroceryList lst : usersLists) {
			 System.out.println("list :  " + lst.getId() + "\n");
			 
			 List<GroceryItem> itemsFromList = itemServ.findByList(lst);

			 for(GroceryItem itm: itemsFromList) {
				itemsOfUser.add(itm);
			 }
			}
		 
		 float sum = 0;
		 
		 for(GroceryItem item : itemsOfUser) {
			 if(item.getConsumptionDate()==null || item.getConsumptionDate().getYear()<2020) {//at first I added wrongly some values for the conumption date
				sum += computeBurndownRateOfProduct(item); 
			 }
		 }
		 
		 if(sum > user.get().getCaloricGoal()) {
			 float val = sum - user.get().getCaloricGoal();
			 message ="Waste level exceeded with " + val;
		 }
		 else {
			 message ="Waste level in normal limits " ;
		 }
		return message;
	}

}



