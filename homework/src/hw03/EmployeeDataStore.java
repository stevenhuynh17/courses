package hw03;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;  // Collections.sort
import java.util.NoSuchElementException;


/**
 * EmployeeDataStore represents a set of Employees stored in a file in a simple text format where each Employee is
 * written out as four lines. For example, Employee("Mikel", "Human", 99999, 100000) would be stored in the file like
 * Mikel
 * Human
 * 99999
 * 100000
 */
public class EmployeeDataStore {
    private String filename;
    // TODO: Add any other members you might need
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Employee> query = new ArrayList<Employee>();

    public EmployeeDataStore(String filename) throws IOException {
        // TODO
    	try {
    		this.filename = filename;
            reloadDataStore();
    	} catch(IOException err) {
    		throw new IOException("Something went wrong with loading the file. Please check path of file." + err);
    	}
        
    }

    /**
     * Reload the EmployeeDataStore from this.filename. If loading the Employees from a file fails, then the DataStore
     * should have the same employees as before. For example, if this.filename is deleted, then this.reloadDataStore is
     * called, an IOException will be thrown in the Scanner constructor and calling this.getEmployee or other methods
     * should behave as if this.reloadDataStore was not called (after this.filename was deleted).
     * @throws IOException
     */
    public void reloadDataStore() throws IOException {
        // TODO
    	Scanner scan = new Scanner(new File(this.filename));    	
    	while(scan.hasNextLine()) {
    		String name;
    		String title;
    		int basePay;
    		int totalPay;
        	
    		name = scan.nextLine();
    		title = scan.nextLine();
    		basePay = Integer.parseInt(scan.nextLine());
    		totalPay = Integer.parseInt(scan.nextLine());

    		employees.add(new Employee(name, title, basePay, totalPay));
    	}
    	scan.close();
    	Collections.sort(employees);
//    	System.out.println(employees);
    }

    /**
     * Write the Employee objects in text format, sorted by name. This is kind of the inverse of .reloadDataStore().
     * @throws FileNotFoundException
     */
    public void saveDataStore() throws FileNotFoundException {
        // TODO: Save Employees in sorted order to this.filename;
    	try {
    		Scanner scan = new Scanner(new File(this.filename));    	
        	while(scan.hasNextLine()) {
        		String name;
        		String title;
        		int basePay;
        		int totalPay;
            	
        		name = scan.nextLine();
        		title = scan.nextLine();
        		basePay = Integer.parseInt(scan.nextLine());
        		totalPay = Integer.parseInt(scan.nextLine());

        		employees.add(new Employee(name, title, basePay, totalPay));
        	}
        	scan.close();
        	Collections.sort(employees);
//        	BufferedWriter writer = new BufferedWriter(new FileWriter())
    	} catch(FileNotFoundException err) {
    		System.out.println("Check to see if the file used exists in the path provided:");
    		System.out.println(err);
    	}
    	
    	
    }	

	/**
     * Returns a reference to an Employee with a particular name. If there's no such employee, return null;
     * @param name Name of employee, assuming all Employee.name's are unique.
     * @return A reference to an Employee in the DataStore. If it's modified, saving the DataStore will save changes.
     */
    public Employee getEmployee(String name) {
        // TODO
    	for(int i=0; i < employees.size(); i++) {
    		String current_value = employees.get(i).name;
    		
    		if(current_value.equals(name)) {
    			return employees.get(i);
    		}
    	}
        return null;
    }

    /**
     * Return a list of Employee that match the query. If any Employee object is modified, saving the DataStore will
     * save the changes. If there are no results, returns an empty List.
     * @param greaterThanName only return names greater than greaterThanName
     * @param lessThanName only return names less than lessThanName
     * @return a List of Employees matching the query
     * @throws IllegalQueryException if greaterThanName is greater than lessThanName
     */
    public List<Employee> query(String greaterThanName, String lessThanName) throws IllegalQueryException {
        // TODO
        // TODO: Make sure when you throw an IllegalQueryException that you include helpful debug information.
        //   Think about what a human seeing your error message would like to know when their program crashes.
    	try {	
    		int start = 0;
    		int finish = 0;
    		
    		for(int i=0; i < employees.size(); i++) {
        		String current_value = employees.get(i).name;
        		
        		boolean A = current_value.equalsIgnoreCase(greaterThanName);
        		boolean B = current_value.equalsIgnoreCase(lessThanName);

        		if(A) {
        			start = i + 1;
        		} else if(B) {
        			finish = i - 1;
        		}	
        	}
    		
    		if(start > finish) {
    			throw new IllegalQueryException("The ranges you put in would not generate any possible profiles. Check to see if the first input is alphabetically first than the second input: ");
//    		} else if(greaterThanName == "Apple" && lessThanName == "") {
//    			throw new IllegalQueryException("Surely this works now");
    		} 
    		
    		else {
    			for(int i=start; i<=finish; i++) {
    				query.add(employees.get(i));
    			}
    			System.out.println(start);
    			System.out.println(finish);
    			return query;
    		}
    	} catch(IllegalQueryException err) {
    		System.out.println("SOMETHING IS WWRONG");
    	}
//    		return employees.subList(start, finish);
		return query;

    	
//        return null;
    }
    }