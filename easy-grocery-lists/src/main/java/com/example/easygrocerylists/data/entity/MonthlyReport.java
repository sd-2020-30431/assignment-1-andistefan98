package com.example.easygrocerylists.data.entity;

import java.util.List;
import java.util.Optional;

import javax.swing.JTextArea;

import com.example.easygrocerylists.business.NewReportGenerator;
import com.example.easygrocerylists.data.entity.ReportType.reportTypes;

public class MonthlyReport implements Report {

	public MonthlyReport(List<GroceryItem> allItems) {
        generateNewReport(allItems);
	}
	
	
	@Override
	public void generateNewReport( List<GroceryItem> allItems) {
		
		  NewReportGenerator.generate(30, allItems);
		
	}


	}


