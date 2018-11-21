package hw03;

public class Employee implements Comparable<Employee>{
	public String name, title;
    public int basePay, totalPay;

    public Employee(String name, String title, int basePay, int totalPay) {
        // TODO
    	this.name = name;
    	this.title = title;
    	this.basePay = basePay;
    	this.totalPay = totalPay;
    }

    @Override
    public int compareTo(Employee other) {
        // TODO: Compare Employee's only based on their names.
        //   Do not use case-insensitive matching. Use the built in String comparing.
    	String first_value = other.name;
    	String second_value = this.name;

    	return second_value.compareTo(first_value);
    }

    @Override
    public String toString() {
        return String.format("Employee(\"%s\", \"%s\", %d, %d)", name, title, basePay, totalPay);
    }
}
