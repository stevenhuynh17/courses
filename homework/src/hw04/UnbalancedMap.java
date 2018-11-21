package hw04;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class UnbalancedMap<K extends Comparable<K>, V> implements SimplerMap<K, V> {
    Node<K, V> root;

    public static class Node<K extends Comparable<K>, V> {
        public K key;
        public V value;
        public Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        boolean containsKey(K key) {
            int cmp = key.compareTo(this.key);
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                // Same as return left == null ? false : left.containsKey(key);
                // Same as if (left == null) { return false; } else { return left.containsKey(key); }
                return left != null && left.containsKey(key);
            } else {  // if (cmp > 0) {
                return right != null && right.containsKey(key);
            }
        }

        V get(K key) {
            return null;  // TODO
        }

        void put(K key, V value) { // EDITED: The original assignment returned V, like java.util.Map
            // TODO
        	K node_key = this.key;

        	// Alphabetizes the keys
        	int compare = key.compareTo(node_key);
        	
        	if(compare < 0) {
        		System.out.println("GO left");
        		if(this.left == null) {
        			// Make the new node if null is found
        			this.left = new Node<>(key, value);
        			System.out.println("CREATED: " + key);
        		} else {
        			// Pass in the key and value to see if the next node has a null left
        			traverse(key, value, this.left);
        		}
        	} else if(compare > 0) {
        		System.out.println("GO right");
        		if(this.right == null) {
        			this.right = new Node<>(key, value);
        			System.out.println("CREATED: " + key);
        		} else {
        			traverse(key, value, this.right);
        		}
        	}
        	
        }
        
        void traverse(K key, V value, Node<K, V> x) {
        	int compare = key.compareTo(x.key);
        	
        	if(compare < 0) {
        		System.out.println("GO left");
        		if(x.left == null) {
        			// Make the new node if null is found
        			x.left = new Node<>(key, value);
        			System.out.println("CREATED: " + key);
        			return;
        		} else {
        			// Pass in the key and value to see if the next node has a null left
        			traverse(key, value, x.left);
        			return;
        		}
        	} else if(compare > 0) {
        		System.out.println("GO right");
        		if(this.right == null) {
        			x.right = new Node<>(key, value);
        			System.out.println("CREATED: " + key);
        			return;
        		} else {
        			traverse(key, value, x.right);
        			return;
        		}
        	}
        	

        }
        
        int size() {
            return -1;  // TODO
        }

        // Note: You do not need to implement toString, but you probably should for your own debugging.
        //   Feel free to share your implementation of toString with other students.

        //
        // Extra Credit
        //
        // Set<K> keySet() {
        //     Set<K> keys = new TreeSet<>();
        //     // TODO
        //     return keys;
        // }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return root == null ? false : root.containsKey(key);
    }

    @Override
    public V get(K key) {
    	System.out.println(root.value);
    	System.out.println(root.left.value);
        return null;  // TODO
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void put(K key, V value) {  // EDITED: The original assignment returned V, like java.util.Map
        if (root == null) {
            root = new Node<>(key, value);
        } else {
            root.put(key, value);
        }
    }

    @Override
    public int size() {
        return -12345;  // TODO
    }

    //
    // Extra Credit
    //

    // @Override
    // public Set<K> keySet() {
    //     return root.keySet();
    // }

    // @Override
    // public void putAll(Map<? extends K, ? extends V> builtinMap) {
    //     // TODO
    // }

    @Override
    public String toString() {  // NOTE: You will not be tested on .toString() but you may want to implement it so it's easier for you to debug.
        return root == null ? "<empty>" : root.toString();
    }
}