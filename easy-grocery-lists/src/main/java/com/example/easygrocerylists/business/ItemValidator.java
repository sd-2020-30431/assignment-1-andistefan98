package com.example.easygrocerylists.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import com.example.easygrocerylists.data.entity.GroceryItem;

public class ItemValidator {
	
	boolean checkItemValidity(GroceryItem item) {
		Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);

		
		if(item.getName() == null)
			return false;
		if(item.getCalorieValue()<=0)
			return false;
		if(item.getQuantity()<=0)
			return false;
		
		
		return true;
		
		
	}

	
	public static Date dateCreator(String month, String day) {
		return java.util.Date                        // Terrible old legacy class, avoid using. Represents a moment in UTC. 
		.from(                                // New conversion method added to old classes for converting between legacy classes and modern classes.
		    LocalDate                         // Represents a date-only value, without time-of-day and without time zone.
		    .of( 2014 , Integer.parseInt(month) , Integer.parseInt(day) )              // Specify year-month-day. Notice sane counting, unlike legacy classes: 2014 means year 2014, 1-12 for Jan-Dec.
		    .atStartOfDay(                    // Let java.time determine first moment of the day. May *not* start at 00:00:00 because of anomalies such as Daylight Saving Time (DST).
		        ZoneId.of( "Europe/Romania" )   // Specify time zone as `Continent/Region`, never the 3-4 letter pseudo-zones like `PST`, `EST`, or `IST`. 
		    )                                 // Returns a `ZonedDateTime`.
		    .toInstant()                      // Adjust from zone to UTC. Returns a `Instant` object, always in UTC by definition.
		);                       
	}
	
}
