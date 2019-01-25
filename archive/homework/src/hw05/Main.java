package hw05;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Main {
    // This program is purely here as a demo. Do not submit it. It is not required.
    public static void main(String[] args) throws IOException {
        String input = "hello world";
        byte[] inputUTF8 = input.getBytes("UTF-8");
	    HuffmanTree tree = new HuffmanTree(
	            args.length > 0 ? new FileInputStream(args[0]) : new ByteArrayInputStream(inputUTF8));

	    List<Boolean> encodedBits = tree.encoded(new ByteArrayInputStream(inputUTF8));

        ByteArrayOutputStream decoded = new ByteArrayOutputStream();
        tree.decoded(encodedBits, decoded);

        System.out.println("Input uses " + inputUTF8.length * 8 + " bits as a standard UTF-8 string.");
        System.out.println("Encoded input using " + encodedBits.size() + " bits:");
        System.out.println(encodedBits);
        System.out.println("Decoded string:");
        System.out.println(decoded.toString("UTF-8"));
    }
}