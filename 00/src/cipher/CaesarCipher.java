package cipher;

public class CaesarCipher {

    // Return a String that is the same as message but where all the alphabetic
    // characters ('a' to 'z' and 'A' to 'Z') have been shifted by shiftAmount.
    // All non-alphabetic characters should remain unchanged. For example,
    // caesarCipher("ab xy!\n",  2).equals("cd za!\n")
    // caesarCipher("cd za!\n", -2).equals("ab xy!\n")
    public static String caesarCipher(String message, int shiftAmount) {
		String output = "";
		for(int i = 0; i < message.length(); i++) {
			int ascii = (int) message.charAt(i);
			System.out.println(Character.toString((char)ascii));
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
    	caesarCipher("test", 2);
    }
}