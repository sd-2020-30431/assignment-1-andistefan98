package com.example.easygrocerylists.business;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import com.example.easygrocerylists.data.entity.GroceryItem;

public class BurnDownRateCalculator {
	
	float computeBurndownRateOfProduct(GroceryItem item) {
		
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
	
	
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}

}



