package hw04;

import java.util.Map;
import java.util.Set;

public interface SimplerMapExtraCredit<K extends Comparable<K>, V> {
    public Set<K> keySet();
    public void putAll(Map<? extends K, ? extends V> builtinMap);
}