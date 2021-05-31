package com.ridersbuddy.finals.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="stocks")
public class Stock {
	@Id
	private String id;
	private String biketype;
	private int quantity;
	private String price;
	
	public Stock() {
		
	}
	
	
	public Stock(String biketype, int quantity, String price) {
	
		this.biketype = biketype;
		this.quantity = quantity;
		this.price = price;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBiketype() {
		return biketype;
	}
	public void setBiketype(String biketype) {
		this.biketype = biketype;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	
	
	
	
}
