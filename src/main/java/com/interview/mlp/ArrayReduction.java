package com.interview.mlp;

import java.util.*;
import java.util.Arrays;

public class ArrayReduction {

    //Array can be reduced by 1 element by performing a move.
    //A move is:
    //Pick two diff elements, remove them, add the sum of them to the end of the array
    //Each move has cost given by sum of the elements removed.
    //Calculate the total cost of reducing the array to 1 element.
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
