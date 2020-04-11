package com.wasteless.business;

import java.util.List;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.MonthlyReport;
import com.wasteless.data.entity.Report;
import com.wasteless.data.entity.User;
import com.wasteless.data.entity.WeeklyReport;
import com.wasteless.data.entity.ReportType.reportTypes;

public class ReportFactory implements ReportAbstractFactory{


	  reportTypes type ;
	    List<GroceryItem> allItems;
	    
	    public ReportFactory(reportTypes type, List<GroceryItem> allItem) {
	    	this.type = type;
	    	this.allItems = allItem;

	    	createReport();
	    }
	    
	    public ReportFactory() {
	    	
	    }
	
    @Override
	public Report createReport() {
		return null;
		
		
		
	}

	@Override
	public Report createReport(reportTypes type, List<GroceryItem> allItems) {
		if(reportTypes.Weekly.equals(type))
			new WeeklyReportFactory(allItems);
		
		if(reportTypes.Monthly.equals(type))
			new MonthlyReportFactory(allItems);
	
		return null;
	}
    
  

	
}
