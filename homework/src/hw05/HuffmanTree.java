package hw05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HuffmanTree {
    // The members below are package-private (instead of private) so it is easier to automatically grade.
    HuffmanNode root;
    Map<Byte, List<Boolean>> bytesToBits;

    static class HuffmanNode implements Comparable<HuffmanNode> {
        // The members below are package-private so that it is easier to automatically grade.
        Byte byteValue;
        int count;
        HuffmanNode left, right;

        HuffmanNode(Byte byteValue, int count) {
            this(byteValue, count, null, null);
        }

        HuffmanNode(Byte byteValue, int count, HuffmanNode left, HuffmanNode right) {
            this.byteValue = byteValue;
            this.count = count;
            this.left = left;
            this.right = right;
        }

        /**
         * Compare two HuffmanNodes based only on their count. A HuffmanNode with a lesser count is lesser.
         * @param other
         * @return
         */
        @Override
        public int compareTo(HuffmanNode other) {
            return 0; // TODO
        }

        boolean isLeafNode() {
            // A node is a leaf node if it does not have any children.
            // left and right are always both null or both non-null.
            return false; // TODO
        }
    }

    /**
     *
     * @param node The current node in the HuffmanTree
     * @param bitsSoFar Path so far in the tree. false means left. true means right. So [false, true] -> root.left.right
     * @param output A map from Byte byteValue to bits (false means 0, true means 1).
     */
    private static void populateBytesToBitsMap(HuffmanNode node, List<Boolean> bitsSoFar, Map<Byte, List<Boolean>> output) {
        if (node.isLeafNode()) {
            output.put(node.byteValue, new ArrayList<>(bitsSoFar));
        } else {
            bitsSoFar.add(false);
            populateBytesToBitsMap(node.left, bitsSoFar, output);
            bitsSoFar.remove(bitsSoFar.size() - 1);
            bitsSoFar.add(true);
            populateBytesToBitsMap(node.right, bitsSoFar, output);
            bitsSoFar.remove(bitsSoFar.size() - 1);
        }
    }

    /**
     * Helper function to generate this.bytesToBits
     * @param root
     * @return
     */
    private static Map<Byte, List<Boolean>> buildBytesToBitsMap(HuffmanNode root) {
        Map<Byte, List<Boolean>> btb = new TreeMap<>();
        List<Boolean> bitsSoFar = new ArrayList<>();
        populateBytesToBitsMap(root, bitsSoFar, btb);
        return btb;
    }

    /**
     * Construct a HuffmanTree which includes all possible bytes, even ones that don't appear in input.
     * @param input InputStream to read bytes from (i.e. a file).
     * @throws IOException
     */
    public HuffmanTree(InputStream input) throws IOException {
        int[] table = getFrequencyTable(input);
        List<HuffmanNode> nodes = new LinkedList<>();
        
        for (int b = 0; b < 256; ++b) {
            nodes.add(new HuffmanNode((byte)b, table[b]));
        }
        
        while (nodes.size() > 1) {
            HuffmanNode a = popMinimumHuffmanNode(nodes);
            HuffmanNode b = popMinimumHuffmanNode(nodes);
            nodes.add(new HuffmanNode(null, a.count + b.count, a, b));
        }
        root = nodes.get(0);
        bytesToBits = buildBytesToBitsMap(root);
    }

    /**
     * Remove and return the smallest HuffmanNode in huffmanNodes.
     * @param huffmanNodes
     * @return
     */
    public static HuffmanNode popMinimumHuffmanNode(List<HuffmanNode> huffmanNodes) {
        return null; // TODO
    }

    /**
     * getFrequencyMap returns a java.util.Map of each Byte to the number of times it occurs in the InputStream.
     * Any Byte that occurs 0 times should not be in the map.
     * @param input
     * @return a Map from Byte to the number of times it occurred in input.
     * @throws IOException if calling a method of input throws IOException
     */
    public static Map<Byte, Integer> getFrequencyMap(InputStream input) throws IOException {
    	Map<Byte, Integer> test = new HashMap<Byte, Integer>();
    	int length = input.available();
    	
    	for(int i=0; i < length; i++) {
    		byte key = (byte) input.read();

    		if(test.get(key) == null) {
    			test.put(key, 1);
    		} else {
    			int increment = test.get(key);
    			test.put(key, ++increment);
    		}
    	
    	}
    	
        return test;  // TODO
    }

    /**
     * getFrequencyTable returns an int array. Where getFrequencyTable(...)[b] is the number of times the byte, b,
     * occurs in the InputStream.
     * getFrequencyTable(...).length == 256: There is one entry for each possible byte, even if a byte never appears
     * in the InputStream.
     * @param input
     * @return
     * @throws IOException if calling a method of input throws IOException
     */
    public static int[] getFrequencyTable(InputStream input) throws IOException {
    	
    	Map<Byte, Integer> result = getFrequencyMap(input);
    	System.out.println(result);
        return new int[256];  // TODO
    }

    /**
     * Read bytes from toEncode and return a list of bits that encode it.
     * @param toEncode
     * @return List of Boolean bits (false == 0, true == 1)
     * @throws IOException if calling a method of toEncode throws IOException
     */
    public List<Boolean> encoded(InputStream toEncode) throws IOException {
        return new Arraylist<>(); // TODO
    }

    /**
     * Iterate over encoded bits and output bytes by going through the HuffmanTree.
     * @param encoded
     * @param output
     * @throws IOException if calling a method of output throws IOException
     */
    public void decoded(List<Boolean> encoded, OutputStream output) throws IOException {
        // TODO
    }
}