package hw04;

import java.util.Set;

// Based on java.util.AbstractMap
public interface SimplerMap<K extends Comparable<K>, V> {
    public void clear();
    public boolean containsKey(K key);
    public V get(K key);
    public boolean isEmpty();
    public void put(K key, V value);  // EDITED: The original assignment returned V, like java.util.Map
    public int size();
}