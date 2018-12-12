package hw03;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;  // Collections.sort
import java.util.LinkedList;
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
    private List<Employee> employees = new LinkedList<Employee>();
    // TODO: Add any other members you might need

    public EmployeeDataStore(String filename) throws IOException {
        // TODO
        this.filename = filename;
        saveDataStore();
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
    }

    /**
     * Write the Employee objects in text format, sorted by name. This is kind of the inverse of .reloadDataStore().
     * @throws IOException
     */
    public void saveDataStore() throws IOException {
        // TODO: Save Employees in sorted order to this.filename;
    	File file = new File(this.filename);
    	Scanner input = new Scanner(file);
    	
    	while(input.hasNextLine()) {
    		String name = input.nextLine();
    		String title = input.nextLine();
    		int basePay = Integer.parseInt(input.nextLine());
    		int totalPay = Integer.parseInt(input.nextLine());
    		
    		employees.add(new Employee(name, title, basePay, totalPay));
    		
    	}
    	input.close();
    	Collections.sort(employees);
    	
    }

    /**
     * Returns a reference to an Employee with a particular name. If there's no such employee, return null;
     * @param name Name of employee, assuming all Employee.name's are unique.
     * @return A reference to an Employee in the DataStore. If it's modified, saving the DataStore will save changes.
     */
    public Employee getEmployee(String name) {
        // TODO
    	for(int i=0; i<employees.size(); i++) {
    		String current = employees.get(i).name;
    		
    		if(current.equals(name)) {
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
    	List<Employee> result = new LinkedList<Employee>();
    	
    	if(greaterThanName.compareTo(lessThanName) > 0) {
    		String message = "First parameter cannot be alphabetically greater than the second parameter";
    		throw new IllegalQueryException(message);
    	}
    	
    	for(int i=0; i<employees.size(); i++) {
    		Employee current = employees.get(i);
    		int lower_bound = greaterThanName.compareTo(current.name);
    		int upper_bound = lessThanName.compareTo(current.name);
    		
    		if(lower_bound < 0 && upper_bound > 0) {
    			result.add(current);
    		}
    	}
    	
        return result;
    }
}