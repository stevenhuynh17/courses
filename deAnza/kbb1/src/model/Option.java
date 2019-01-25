package model;

import java.io.Serializable;

// Methods are to be protected
public class Option implements Serializable{
	private String name; 
	private float price;
	
	public String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
