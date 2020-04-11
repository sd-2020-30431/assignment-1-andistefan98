package com.wasteless.data.entity;

import java.util.List;

import javax.swing.JTextArea;

import com.wasteless.business.NewReportGenerator;
import com.wasteless.data.entity.ReportType.reportTypes;

public class WeeklyReport implements Report{


	public WeeklyReport(List<GroceryItem> allItems) {

        generateNewReport(allItems);
	}
	
	
	@Override
	public void generateNewReport(List<GroceryItem> allItems) {

           NewReportGenerator.generate(7,allItems); 
		
	}

	
	

	
}
