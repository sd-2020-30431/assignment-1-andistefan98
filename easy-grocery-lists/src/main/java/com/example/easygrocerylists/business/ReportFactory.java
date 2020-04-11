package com.example.easygrocerylists.business;

import java.util.List;

import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.MonthlyReport;
import com.example.easygrocerylists.data.entity.Report;
import com.example.easygrocerylists.data.entity.ReportType.reportTypes;
import com.example.easygrocerylists.data.entity.User;
import com.example.easygrocerylists.data.entity.WeeklyReport;

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
		

		if(reportTypes.Weekly.equals(type))
			new WeeklyReportFactory(allItems);
		
		if(reportTypes.Monthly.equals(type))
			new MonthlyReportFactory(allItems);
	
		return null;
		
	}

	@Override
	public Report createReport(reportTypes type, List<GroceryItem> allItems) {
		// TODO Auto-generated method stub
		return null;
	}
    
  

	
}
