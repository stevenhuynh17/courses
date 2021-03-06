package hw01;

import java.io.FileNotFoundException;

public class CaesarCipher {
    public static String caesarCipher(String message, int shiftAmount) {
		String output = "";
		
		for(int i = 0; i < message.length(); i++) {
			// Convert each letter into ascii. Establish remainder based on number of letters in alphabet
			int ascii = (int) message.charAt(i);
			int updated_shift = shiftAmount % 26;
			
			// Narrow down the range of letters targeted from ascii table.
			if(ascii <= 'z' && ascii >= 'a') {				
				// Shift values and output result
				int update_ASCII = ascii + updated_shift;
				if(update_ASCII > 'z') {
					update_ASCII -= 26;
				} else if(update_ASCII < 'a') {
					update_ASCII += 26;
				}
				String update_letter = Character.toString((char)update_ASCII);
				
				output = output + update_letter;
			} else if(ascii <= 'Z' && ascii >= 'A') {
				int update_ASCII = ascii + updated_shift;
				if(update_ASCII > 'Z') {
					update_ASCII -= 26;
				} else if(update_ASCII < 'A') {
					update_ASCII += 26;
				}
				String update_letter = Character.toString((char)update_ASCII);
				
				output = output + update_letter;
			} else {
				String unmodified = Character.toString((char)ascii);
				output = output + unmodified;
			}
		}
		return output;
    }

    public static void main(String args[]) throws FileNotFoundException{
    	System.out.println(Math.atan(1));
    	System.out.println(Math.atan2(-1, -1));
    	
    	if(args.length >= 1) {
    		int shiftAmount = Integer.valueOf(args[0]);
    		for(int i = 1; i < args.length; i++) {
    			System.out.println(caesarCipher(args[i], shiftAmount));	
    		}
    	}
//    	System.out.println("10: " + caesarCipher("ab !xy!\n", 1234567));
//    	System.out.println("10: " + caesarCipher("JK !GH!\n", -1234567));
    }
}