package hw01;

public class CaesarCipher {
    public static String caesarCipher(String message, int shiftAmount) {
		String output = "";
		
		for(int i = 0; i < message.length(); i++) {
			// Convert each letter into ascii. Establish remainder based on ascii table.
			int ascii = (int) message.toLowerCase().charAt(i);
			int updated_shift = shiftAmount % 255;
			
			// Narrow down the range of letters targeted from ascii table.
			if(ascii > 122 || ascii < 97) {
				String unmodified = Character.toString((char)ascii);
				output = output + unmodified;
				continue;
			} else {
				// Restrict ascii to affect only A-Z alphabet
				if(ascii > 26) {
					updated_shift = updated_shift % 26;
				}
				
				// Shift values and output result
				int update_ASCII = ascii + updated_shift;
				if(update_ASCII > 122) {
					update_ASCII -= 26;
				} else if(update_ASCII < 97) {
					update_ASCII += 26;
				}
				String update_letter = Character.toString((char)update_ASCII);
				
				output = output + update_letter;
			}
		}
		return output;
    }

    public static void main(String args[]) {
    	if(args.length > 1) {
    		int shiftAmount = Integer.valueOf(args[0]);
    		for(int i = 1; i < args.length; i++) {
    			System.out.println(caesarCipher(args[i], shiftAmount));
    		}
    	}
    	System.out.println("12345: " + caesarCipher("ab xy!\n", 12345));
    	System.out.println("127657345: " + caesarCipher("ab xy!\n", 127657345));
    	System.out.println("-127657345: " + caesarCipher("ab xy!\n", -127657345));
    }
}