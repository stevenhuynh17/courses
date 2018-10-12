package hw01;

public class CaesarCipher {
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
		return output;
    }

    public static void main(String args[]) {
    	if(args.length > 1) {
    		Integer shiftAmount = Integer.valueOf(args[0]);
    		for(int i = 1; i < args.length; i++) {
    			System.out.println(caesarCipher(args[i], shiftAmount));
    		}
    	}
    	System.out.println(caesarCipher("z!z", 0));
    }
}