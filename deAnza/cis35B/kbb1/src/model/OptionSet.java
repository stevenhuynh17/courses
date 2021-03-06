package model;

import java.io.Serializable;

//Methods are to be protected
public class OptionSet implements Serializable{
	private Option opt [];
	private String name;
	
	public OptionSet(String n, int size) {
		this.opt = new Option[size];
		this.name = n; 
		
		for(int i = 0; i< opt.length; i++) {
			opt[i] = new Option();
		}
	}
	
	public Option[] getOpt() {
		return opt;
	}

	public void setOpt(String name, float price, int index) {
		opt[index].setName(name);
		opt[index].setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}