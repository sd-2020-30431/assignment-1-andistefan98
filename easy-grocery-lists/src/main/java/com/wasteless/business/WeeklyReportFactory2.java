package com.wasteless.business;

import java.util.List;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.Report;
import com.wasteless.data.entity.ReportType.reportTypes;
import com.wasteless.data.entity.WeeklyReport;

 class WeeklyReportFactory2 extends AbstractFactory {



	public Report getReport(reportTypes type, List<GroceryItem> items) {
		return new WeeklyReport(items);
	} 
	 
}
