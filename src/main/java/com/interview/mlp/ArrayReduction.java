package com.interview.mlp;

import java.util.*;
import java.util.Arrays;

public class ArrayReduction {

    public static int reduceArray( int[] nums ){
        Arrays.sort(nums);

        Deque<Integer> numsList = new ArrayDeque<>();
        Arrays.stream(nums).forEachOrdered( x -> numsList.add(x));

        int totalCost = 0;

        while( numsList.size() > 1 ){
            int sum  = numsList.removeFirst() + numsList.removeFirst();
            numsList.addLast(sum);
            totalCost = totalCost + sum;
        }

        return totalCost;

    }



    public static void main(String[] args) {
        System.out.println( reduceArray( new int[]{1, 2, 3}));
    }

}
