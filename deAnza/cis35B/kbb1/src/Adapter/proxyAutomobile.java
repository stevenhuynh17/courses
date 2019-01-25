package Adapter;

import java.io.*;

import exception.*;
import model.*;
import util.FileIO;

public abstract class proxyAutomobile {
	private Automobile a1; 
	private String fileName;
	proxyAutomobile() {}
	
	public proxyAutomobile(String fileName) {
		super();
		this.fileName = fileName; 
		System.out.println("IT'S WORKING??!?!");
	}
	
	public boolean BuildAuto(String filename) throws AutoException {
		boolean problemFixed = false;
		
		try {
			System.out.println("Attempting to read file...");
			a1 = FileIO.readFile(filename);
		} catch(FileNotFoundException e) {
			throw new AutoException(1);
		}
		return true;
	}
	
	public void printAuto(String modelName) {
		System.out.println("MODEL NAME: " + a1.getName());
		System.out.println("BASE PRICE: " + a1.getBaseprice());
		System.out.println("OPTIONS: ");
		
		for(int i = 0; i < a1.getOpset()[0].getOpt().length; i++) {
			System.out.println("- " + a1.getOpset()[0].getOpt()[i].getName().trim() + ": " + a1.getOpset()[0].getOpt()[i].getPrice());
		}
		System.out.println();
	}
	
	public void updateOptionSetName(String modelName, String optionSetName, String newName) {
		System.out.println("CHANGING SET NAME!!!");
		System.out.println("BEFORE: " + a1.getOpset()[0].getName());
		a1.getOpset()[0].setName(newName);
		System.out.println("AFTER: " + a1.getOpset()[0].getName());
		System.out.println();
	}
	
	public void updateOptionPrice(String modelName, String optionName, String option, float newPrice) {
		System.out.println("CHANGING OPTION PRICE!!!");
		System.out.println("BEFORE: " + a1.getOpset()[0].getOpt()[0].getPrice());
		a1.getOpset()[0].getOpt()[0].setPrice(newPrice);
		System.out.println("AFTER: " + a1.getOpset()[0].getOpt()[0].getPrice());
	}
}
