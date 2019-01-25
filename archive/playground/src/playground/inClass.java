package playground;

import java.util.ArrayList;

// Take an array of int, output in sorted order

class GenericCounter<E> {
	ArrayList<GenericCountPair<E>> counts;
	
	GenericCounter() {
		counts = new ArrayList<>();
	}
	
	void incrementCount(E x) {
		x++;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		return "" + counts;
	}
}

public class inClass {
	public static void main(String[] args) {
		int[] data = {1, 3, 2};
		sort(data);
	}
	
	public static int[] sort(int[] input) {
		int[] output;
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		// Keep track of lowest number and push it into the output
		// 
		return null;
	}
}
