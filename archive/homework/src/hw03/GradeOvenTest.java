package hw03;

import java.io.IOException;
import java.util.List;

public class GradeOvenTest {
	public static void main(String[] args) throws IOException {
		String filename = "/Users/StevenH/Desktop/Coding/CS1B/homework/src/hw03/2014-foothill-cs-simplified.txt";
		EmployeeDataStore store = new EmployeeDataStore(filename);
		
		System.out.println(store.getEmployee("Bita Mazloom"));
		
		List<Employee> test = store.query("Cat", "Apple");
	}
}
