package com.wasteless.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.GroceryList;

public class ItemValidator {
	

	
	public static boolean checkItemValidity(String name, int quantity , float caloricValue , Date purchase, Date exp, Date con, GroceryList list) {
		Date today = new Date(); 
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		
		
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH); 
		int month = cal.get(Calendar.MONTH); 
		
		if( name == null)
			return false;
		if(caloricValue <=0)
			return false;
		if(quantity<=0)
			return false;
		
	if(purchase.after(today))
		return false;

		
		return true;
		
		
	}

	
	public static Date dateCreator(String month, String day) {
		/*return java.util.Date                        // Terrible old legacy class, avoid using. Represents a moment in UTC. 
		.from(                                // New conversion method added to old classes for converting between legacy classes and modern classes.
		    LocalDate                         // Represents a date-only value, without time-of-day and without time zone.
		    .of( 2020 , Integer.parseInt(month) , Integer.parseInt(day) )              // Specify year-month-day. Notice sane counting, unlike legacy classes: 2014 means year 2014, 1-12 for Jan-Dec.
		    .atStartOfDay(                    // Let java.time determine first moment of the day. May *not* start at 00:00:00 because of anomalies such as Daylight Saving Time (DST).
		        ZoneId.of( "Europe/Romania" )   // Specify time zone as `Continent/Region`, never the 3-4 letter pseudo-zones like `PST`, `EST`, or `IST`. 
		    )                                 // Returns a `ZonedDateTime`.
		    .toInstant()                      // Adjust from zone to UTC. Returns a `Instant` object, always in UTC by definition.
		);   
		*/
		
		Calendar c = Calendar.getInstance();
		c.set(2020, Integer.parseInt(month) - 1, Integer.parseInt(day), 0, 0);  

	    java.util.Date date = c.getTime();
	    
	    return date;
		
		
	}
	
	
	public boolean checkConsumptionDate(Date consump) {
		if(consump.compareTo(new Date())>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
