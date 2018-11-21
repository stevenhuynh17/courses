package hw03;

import java.io.IOException;

public class GradeOvenTest {
	public static void main(String[] args) throws IOException {
		String filename = "/Users/StevenH/Desktop/Coding/CS1B/homework/src/hw03/2014-foothill-cs-simplified.txt";
		EmployeeDataStore store = new EmployeeDataStore(filename);
		Employee test = store.getEmployee("Bita Mazloom");
		store.query("Apple", "");
	}
}
