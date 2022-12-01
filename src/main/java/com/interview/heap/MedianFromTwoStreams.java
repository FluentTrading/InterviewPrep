package com.interview.heap;

import java.util.*;

public class MedianFromTwoStreams {

    //Keep two heaps, min and max
    //a) First num, add o min and then rebalance to max
    //b) Then, add to max and rebalance to min

    // This is to keep the heaps balanced so that the median is either
    //a) For even number of inputs, the avg of the top two values in the heaps
    //b) For odd number of inputs, the top max values.

    private boolean addToMin = true;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>( Collections.reverseOrder() );

    public void addNum( int num ){
        if( addToMin ){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }

        addToMin = !addToMin;
    }


    public double findMedian() {
        boolean evenNumberOfInputs = ((minHeap.size() + maxHeap.size()) %2 == 0);
        if( evenNumberOfInputs ){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else{
            return maxHeap.peek();
        }
    }



}
