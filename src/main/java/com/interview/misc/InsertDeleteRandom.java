package com.interview.misc;

import java.util.*;

public class InsertDeleteRandom {

    private final Random random;
    private final Map<Integer, Integer> store;
    private final ArrayList<Integer> reverseStore;

    public InsertDeleteRandom( ){
        this.random = new Random();
        this.store = new HashMap<>();
        this.reverseStore = new ArrayList<>();
    }

    public boolean insert( int val ){
        if( store.containsKey(val) ) {
            return false;
        }

        int thisIndex = reverseStore.size();
        store.put(val, thisIndex);
        reverseStore.add(thisIndex, val);
        return true;

    }


    /**
     * Store:       ReverseStore:
     * <4, 0>       <0, 4>
     * <5, 1>       <1, 5>
     * <7, 2>       <2, 7>
     *
     * Remove 5
     * Copy the last value to the index of 5, then delete 5
     *
     * Store:       ReverseStore:
     * <4, 0>       <0, 4>
     * <5, 1>       <1, 7>
     * <7, 1>       <2, 7>
     *
     * Remove val from Store and lastIndex from reverseStore
     * Store:       ReverseStore:
     * <4, 0>       <0, 4>
     * <5, 1>       <1, 7>
     *
     */

    public boolean remove( int val ){
        if( !store.containsKey(val)){
            return false;
        }

        int thisIndex = store.get(val);
        int lastIndex = reverseStore.size() -1;
        int lastVal = reverseStore.get(lastIndex);

        //Copy last value to index of number being removed, then remove the number
        store.put(lastVal, thisIndex);
        reverseStore.set( thisIndex, lastVal );

        //Remove
        reverseStore.remove( lastIndex );
        store.remove(val);

        return true;
    }


    public int getRandom( ){
        int randomBoundedInt = random.nextInt( reverseStore.size() - 0 ) + 0;
        return reverseStore.get(randomBoundedInt);
    }

}
