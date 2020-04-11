package com.wasteless.business;

import java.util.List;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.ReportType.reportTypes;

public class ReportCreator {

	 public static AbstractFactory getFactory(reportTypes choice , List<GroceryItem> items){  
	      if(choice.equals(reportTypes.Weekly)){  
	        
	    	  return new WeeklyReportFactory2();  
	      } else {  
	      
	    	  return new MonthlyReportFactory2();  
	      }  
	   }  
}
