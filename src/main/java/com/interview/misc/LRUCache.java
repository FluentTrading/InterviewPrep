package com.interview.misc;

import java.util.*;

public class LRUCache<K, V>{

    private final int capacity;
    private final Map<K, V> cache;
    private final ArrayDeque<K> lruList;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lruList = new ArrayDeque<>();
        this.cache = new HashMap<>( );
    }

    public V get( K key ){
        V value = cache.get(key);
        if( value == null ){
            return null;
        }

        moveKeyToFront( key );
        return value;
    }


    public void put( K key, V value ){
        if( cache.containsKey(key)){
            moveKeyToFront( key );
        }else{
            if( cache.size() == capacity ){
                cache.remove(lruList.removeLast());
            }
            lruList.addFirst(key);
        }

        cache.put(key, value);
    }

    protected void moveKeyToFront( K key ){
        lruList.remove(key);
        lruList.addFirst(key);
    }



    public static void main( String[] args ){

        LRUCache<Integer, Integer> lRUCache  = new LRUCache<>(2);
        lRUCache.put(1, 1);     // cache is {1=1}
        lRUCache.put(2, 2);     // cache is {1=1, 2=2}
        lRUCache.get(1);                // return 1
        lRUCache.put(3, 3);    // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);                // returns -1 (not found)
        lRUCache.put(4, 4);    // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);                // return -1 (not found)
        lRUCache.get(3);                // return 3
        lRUCache.get(4);                // return 4

    }


}

