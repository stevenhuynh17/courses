package util;

import java.io.*;
import java.util.*;


import model.*;
import util.*;

public class FileIO {	
	public static Automobile readFile(String filename) {
		Automobile a1 = new Automobile(null, null, null, 5);
		
		try {
			
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file); 
			
			boolean eof = false; 
			boolean header = true; 
			
			int index = 0; 
			
			while(!eof) {
				String line = buff.readLine();
				
				if(line == null) {
					eof = true;  
				} else if(header == true) {
					header = false;
					continue;
				} else {
					String[] current = line.split("\\,");
					// Determine if there is a base price or not in the text file. 					
					
					for(int i = 2; i < current.length; i++) {
						String[] features = current[i].split("\\:");
						a1.getOpset()[0].setOpt(features[0],  Float.valueOf(features[1]), i - 2);		
					}
					
					a1.setName(current[0]);
					a1.setBaseprice(current[1].replaceAll("\\s+", ""));
					a1.setOpset(a1.getOpset());
//					Serialize(a1);
					index++; 
				}
			}
		} catch(IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		return a1;
		
	}
	
	public static void Serialize(Automobile obj) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Ford.dat"));
			out.writeObject(obj);
			out.close();
		} catch(Exception e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}		
	}
	
	public static Automobile Deserialize(String file) {
		Automobile car = null; 
		try {
			FileInputStream fileIn = new FileInputStream("Ford.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			car = (Automobile) in.readObject();
			in.close();
			fileIn.close();
		} catch(Exception e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}
		return car;
	}
}
