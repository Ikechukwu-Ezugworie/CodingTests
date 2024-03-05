package test;

import java.util.HashMap;
import java.util.Stack;

public class LRUCache {
    private int capacity;
    private HashMap<Integer, Integer> cache;
    private Stack<Integer> cacheMemory = new Stack<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(this.capacity);
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        //check if the key exists
        if (!this.cache.containsKey(key)) { //if it exists update the value
            if (cache.keySet().size() == capacity) { //check if the cache has reached max capacity
                int lastUsedKey = cacheMemory.pop(); //if YES pop the last used key from the stack memory and remove it from the map
                cache.remove(lastUsedKey);
            }
            cache.put(key, value); //if NO just add the key to the map
            updateKeyInCacheMemory(key); //then add it to the top of the memory

        } else { //if it exists update the value
            updateKeyInCacheMemory(key);
        }
    }

    private void updateKeyInCacheMemory(int key) {
        int index = cacheMemory.indexOf(key);
        if (index != -1) {
            cacheMemory.remove(index);
        }
        cacheMemory.push(key);
    }
}

