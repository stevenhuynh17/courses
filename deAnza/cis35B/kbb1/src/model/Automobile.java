package model;

import java.io.Serializable;
import java.util.*;

import Adapter.*;
import util.FileIO;

public class Automobile implements Serializable {
	private String name;
	private String baseprice; 
	private OptionSet[] opset;

	public Automobile (String name, String baseprice, OptionSet[] opset, int size) {
		this.name = name;
		this.baseprice = baseprice;
		this.opset = new OptionSet[size];
		
		// Instantiate the OptionSets
		for(int i = 0; i < this.opset.length; i++) {
			this.opset[i] = new OptionSet("Car " + (i + 1), 5);
		}
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getBaseprice() {
		return baseprice;
	}
	
	public OptionSet[] getOpset() {
		return opset;
	}

	// Setters 
	public void setName(String name) {
		this.name = name;
	}

	public void setBaseprice(String baseprice) {
		this.baseprice = baseprice;
	}

	public void setOpset(OptionSet[] opset) {
		this.opset = opset;
	}
	
	
	
//	public void setOpset(OptionSet[] opset, int index) {
//	opset[index] = ;
//}
	
}
