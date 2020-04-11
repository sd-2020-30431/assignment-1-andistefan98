package com.wasteless.business;

import java.util.List;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.Report;
import com.wasteless.data.entity.User;
import com.wasteless.data.entity.ReportType.reportTypes;

public interface ReportAbstractFactory {

	public Report createReport(reportTypes type , List<GroceryItem> allItems) ;

	public Report createReport();

	//Report createReport();
	
}
