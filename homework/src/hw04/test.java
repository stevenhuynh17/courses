package hw04;

public class test {
	public static void main(String[] args) {
		String city = "Turlock city";
		int pop = 68549;
		UnbalancedMap<String, Integer> x = new UnbalancedMap<>();
		x.put(city, pop);
		
		x.put("S", 1000000);
		x.put("B", 1343);
		x.put("A", 12);
		x.put("Z", 3089);
		x.put("Y", 1234);

	}
}
