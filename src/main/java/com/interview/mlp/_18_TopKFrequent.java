package com.interview.mlp;

import java.util.*;

public class _18_TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for( int num : nums ){
            freqMap.put( num, freqMap.getOrDefault(num, 0) + 1 );
        }
        System.out.println("Frequency: " + freqMap );

        //Order min heap by frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>( (x, y) -> (x.getValue() - y.getValue()) );

        for( Map.Entry<Integer, Integer> entry : freqMap.entrySet() ){

            if( minHeap.size() < k ){
                minHeap.add(entry);
            }else{

                if( minHeap.peek().getValue() < entry.getValue() ){
                    minHeap.poll();
                    minHeap.add( entry );
                }
            }
        }

        int[] result = new int[k];
        int indx = 0;

        while( !minHeap.isEmpty() ){
            result[indx++] = minHeap.poll().getKey();
        }

        return result;
    }

}
