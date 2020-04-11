package com.example.easygrocerylists.business;

import java.util.List;

import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.MonthlyReport;
import com.example.easygrocerylists.data.entity.Report;
import com.example.easygrocerylists.data.entity.ReportType;
import com.example.easygrocerylists.data.entity.ReportType.reportTypes;
import com.example.easygrocerylists.data.entity.User;
import com.example.easygrocerylists.data.entity.WeeklyReport;

public class MonthlyReportFactory extends ReportFactory{

	
	@Override
	public Report createReport(reportTypes type, List<GroceryItem> allItems) {
	return null;
	}

	public MonthlyReportFactory(List<GroceryItem> allItems) {

		new MonthlyReport(allItems);
		
	}
	
	
}
