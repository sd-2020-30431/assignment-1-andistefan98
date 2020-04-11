package com.example.easygrocerylists.business;

import java.util.List;

import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.MonthlyReport;
import com.example.easygrocerylists.data.entity.Report;
import com.example.easygrocerylists.data.entity.ReportType;
import com.example.easygrocerylists.data.entity.User;
import com.example.easygrocerylists.data.entity.WeeklyReport;
import com.example.easygrocerylists.data.entity.ReportType.reportTypes;

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
