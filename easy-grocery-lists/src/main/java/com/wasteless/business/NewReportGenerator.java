package com.wasteless.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wasteless.data.entity.FinalReport;
import com.wasteless.data.entity.GroceryItem;

public class NewReportGenerator {

	
	public static void generate(int noDays, List<GroceryItem> allItems) {
		
		Date dateNow = new Date();
		
		List<GroceryItem> targetItems = new ArrayList<GroceryItem>();
		 Date date = new Date(System.currentTimeMillis() - noDays * 24 * 60 * 60 * 1000L);
		
		 for(GroceryItem itm : allItems) {
			 if(itm.getPurchaseDate().before(dateNow) ) {
				 if(itm.getPurchaseDate().after(date))
				 targetItems.add(itm);
			 }
		 }
		 
		 int noOfTargetItems  = targetItems.size();
		 List<GroceryItem> expiredItems = new ArrayList<GroceryItem>();
		 
		 for(GroceryItem itm : targetItems) {
			 if(itm.getExpirationDate().before(dateNow)) {
				 if(itm.getConsumptionDate()==null )
				   expiredItems.add(itm);
			 }
		 }
		 
		 float wastedCalories = 0;
		 
		 for(GroceryItem itm : expiredItems) {
			 wastedCalories += itm.getCalorieValue() * itm.getQuantity();
			 
		 }
		 
	
		 new FinalReport(targetItems,noOfTargetItems,expiredItems,wastedCalories);
		 
	}
	
	
}
