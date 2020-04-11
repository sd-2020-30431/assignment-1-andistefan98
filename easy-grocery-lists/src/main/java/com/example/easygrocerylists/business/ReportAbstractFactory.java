package com.example.easygrocerylists.business;

import java.util.List;

import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.Report;
import com.example.easygrocerylists.data.entity.ReportType.reportTypes;
import com.example.easygrocerylists.data.entity.User;

public interface ReportAbstractFactory {

	public Report createReport(reportTypes type , List<GroceryItem> allItems) ;

	public Report createReport();

	//Report createReport();
	
}
