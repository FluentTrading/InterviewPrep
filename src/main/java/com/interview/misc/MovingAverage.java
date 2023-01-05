package com.interview.misc;

import java.util.*;


/**
 *  Given a stream of integers and a window size,
 *  calculate the moving average of all integers in the sliding window.
 */
public class MovingAverage {

    private double movingSum;
    private int windowSize;
    private LinkedList<Integer> queue;

    public MovingAverage( int windowSize ){
        this.movingSum= 0;
        this.windowSize = windowSize;
        this.queue = new LinkedList<>();
    }

    public double next( int val ){
        //Make room and decrement sum by subtracting the oldest element
        if( queue.size() == windowSize ){
            movingSum = movingSum - queue.poll();
        }

        queue.offer(val);
        movingSum += val;
        return movingSum/queue.size();
    }

    public static void main(String[] args) {
        MovingAverage avg = new MovingAverage(3);
        System.out.println( avg.next(1));
        System.out.println( avg.next(2));
        System.out.println( avg.next(3));
        System.out.println( avg.next(5));

    }

}
