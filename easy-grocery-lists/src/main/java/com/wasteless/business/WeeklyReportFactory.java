package com.wasteless.business;

import java.util.List;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.MonthlyReport;
import com.wasteless.data.entity.Report;
import com.wasteless.data.entity.ReportType;
import com.wasteless.data.entity.User;
import com.wasteless.data.entity.WeeklyReport;
import com.wasteless.data.entity.ReportType.reportTypes;

public class WeeklyReportFactory extends ReportFactory{


	//private User user;
//	private static reportTypes type ;
    //static List<GroceryItem> allItems;
	
	public WeeklyReportFactory(List<GroceryItem> allItems) {
   
		new WeeklyReport(allItems);
	
	}
	

	@Override
	public Report createReport(reportTypes typee, List<GroceryItem> allItems) {
		return null;
	
	}
	


	
	
}
