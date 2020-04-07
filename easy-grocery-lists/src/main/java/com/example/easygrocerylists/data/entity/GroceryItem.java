package com.example.easygrocerylists.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class GroceryItem {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String name;
	@Column
	int quantity;
	@Column
	float calorieValue;
	@Column
	Date purchaseDate;
	@Column
	Date expirationDate;
	@Column
	Date consumptionDate;
	
	
	
	public GroceryItem(String nmm, int qnt , float calories, Date purch, Date exp, Date consump) {
		this.name= nmm;
		this.quantity = qnt;
		this.calorieValue = calories;
		this.purchaseDate = purch;
		this.expirationDate =exp;
		this.consumptionDate = consump; 
		
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getCalorieValue() {
		return calorieValue;
	}

	public void setCalorieValue(float calorieValue) {
		this.calorieValue = calorieValue;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getConsumptionDate() {
		return consumptionDate;
	}

	public void setConsumptionDate(Date consumptionDate) {
		this.consumptionDate = consumptionDate;
	}

    @Override
	public String toString() {
		return "Product: " + name + "   Calories:  " + calorieValue;
		
	}
	
	
	
}
