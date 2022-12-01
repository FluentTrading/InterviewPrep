package com.interview.misc;

import java.util.*;

public class TimeBasedKeyValue {

    private Map<String, TreeMap<Integer, String>> map;

    public TimeBasedKeyValue(){
        this.map = new HashMap<>();
    }

    public void set( String key, String value, int timestamp ){
        TreeMap<Integer, String> innerMap = map.getOrDefault(key, new TreeMap<>());
        innerMap.put(timestamp, value);
        map.put( key, innerMap );
    }

    public String get( String key, int timestamp ){
        TreeMap<Integer,String> innerMap = map.get(key);
        if( innerMap == null ) return "";

        //FloorKey: Returns the greatest key less than or equal to the given key, or null if there is no such key.
        Integer floor = innerMap.floorKey(timestamp);
        return (floor == null) ? "" : innerMap.get(floor);

    }


    //Above get uses TreeMap floorKey.
    //If that is not an option
    public String get1( String key, int timestamp ){

        Map<Integer, String> innerMap = map.get(key);
        if( innerMap == null ) return "";

        String directMatchValue = innerMap.get(timestamp);
        if( directMatchValue != null ) return directMatchValue;

        //Linear scan with decreasing timestamp till you find it
        System.out.println("No direct match found for Key: " + key + " at timestamp " + timestamp );
        int tmpTimestamp = timestamp;

        while( tmpTimestamp >= 1 ){
            tmpTimestamp = tmpTimestamp-1;
            String indirectMatchValue = innerMap.get(tmpTimestamp);
            if( indirectMatchValue != null ){
                return indirectMatchValue;
            }
        }

        return "";

    }

}
