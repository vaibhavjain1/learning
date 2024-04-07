package collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMap {
    private LinkedHashMap<Integer, Integer> linkHashMap;

    public LRUCacheLinkedHashMap(int capacity) {
        //LinkedHashMap's following constructor helps us to make the access-order True/False. If it is false then it keeps the insertion-order.
        linkHashMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public void put(int key, int value) {
        linkHashMap.put(key, value);
    }

    public int get(int key) {
        return linkHashMap.getOrDefault(key, -1);
    }
}
