package hw01;

public class CaesarCipher {

    // Return a String that is the same as message but where all the alphabetic
    // characters ('a' to 'z' and 'A' to 'Z') have been shifted by shiftAmount.
    // All non-alphabetic characters should remain unchanged. For example,
    // caesarCipher("ab xy!\n",  2).equals("cd za!\n")
    // caesarCipher("cd za!\n", -2).equals("ab xy!\n")
    public static String caesarCipher(String message, int shiftAmount) {
		String output = "";
		
		for(int i = 0; i < message.length(); i++) {
			int ascii = (int) message.toLowerCase().charAt(i);
			int updated_shift = shiftAmount % 255;
			System.out.println(ascii);
			System.out.println(updated_shift);
			if(ascii > 122 || ascii < 97) {
				String unmodified = Character.toString((char)ascii);
				output = output + unmodified;
				continue;
			} else {
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
        // for each character, c in message:
        //   if c >= 'a' and <= 'z'
        //     shift c by shiftAmount
        //   else if c >= 'A' and <= 'Z'
        //     shift c by shiftAmount
        // add c to output
		return output;
    }

    // Print the cipher of args[1], args[2], etc. on their own lines
    // shifted by args[0].
    public static void main(String args[]) {
        // Read shiftAmount from args[0]
        // for each arg in args[1], args[2], etc.:
        //   print caesarCipher(...)
    	if(args.length > 1) {
    		Integer shiftAmount = Integer.valueOf(args[0]);
    		for(int i = 1; i < args.length; i++) {
    			System.out.println(caesarCipher(args[i], shiftAmount));
    		}
    	}
//    	System.out.println(caesarCipher("b!b", -767));
    }
}