package com.wasteless.business;

import java.util.List;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.MonthlyReport;
import com.wasteless.data.entity.Report;
import com.wasteless.data.entity.ReportType.reportTypes;

class MonthlyReportFactory2 extends AbstractFactory{


	public Report getReport(reportTypes type ,  List<GroceryItem> items){  

	      return new MonthlyReport(items);
	   } 
	
}
