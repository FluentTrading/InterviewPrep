package com.interview.heap;

import java.util.*;

public class MedianFromTwoStreams {

    //Keep two heaps, min and max
    //a) First num, add to minHeap and then rebalance to maxHeap
    //b) Then, add to maxHeap and rebalance to minHeap
    //c) Keep alternating

    // This keeps the heaps balanced so that the median is either
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
            //Average of two top values
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else{
            return maxHeap.peek();
        }
    }



}
