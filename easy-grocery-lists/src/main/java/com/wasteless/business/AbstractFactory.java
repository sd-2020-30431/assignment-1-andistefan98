package com.wasteless.business;

import java.util.List;

import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.Report;
import com.wasteless.data.entity.ReportType.reportTypes;

public abstract class AbstractFactory {

	public abstract Report getReport(reportTypes type, List<GroceryItem> items );  
	
}
