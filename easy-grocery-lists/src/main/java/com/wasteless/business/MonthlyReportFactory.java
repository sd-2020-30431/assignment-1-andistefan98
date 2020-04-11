package com.wasteless.business;

import java.util.List;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.MonthlyReport;
import com.wasteless.data.entity.Report;
import com.wasteless.data.entity.ReportType;
import com.wasteless.data.entity.User;
import com.wasteless.data.entity.WeeklyReport;
import com.wasteless.data.entity.ReportType.reportTypes;

public class MonthlyReportFactory extends ReportFactory{

	
	@Override
	public Report createReport(reportTypes type, List<GroceryItem> allItems) {
	return null;
	}

	public MonthlyReportFactory(List<GroceryItem> allItems) {

		new MonthlyReport(allItems);
		
	}
	
	
}
