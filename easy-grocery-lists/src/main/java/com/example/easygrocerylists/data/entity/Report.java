package com.example.easygrocerylists.data.entity;

import java.util.List;
import java.util.Optional;

import javax.swing.JTextArea;

public interface Report {

	void generateNewReport(List<GroceryItem> allItems);
	
}
