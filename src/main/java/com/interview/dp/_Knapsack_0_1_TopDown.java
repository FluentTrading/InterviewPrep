package com.interview.dp;

import java.util.Arrays;


public class _Knapsack_0_1_TopDown {

    public static int knapsack( int capacity, int[] weights, int[] values ){
        System.out.println( "Capacity: " + capacity );
        System.out.println( "Weights: " + Arrays.toString(weights) );
        System.out.println( "Values: " + Arrays.toString(values) );

        return doKnapsack( weights.length-1, capacity, weights, values );
    }


    private static int doKnapsack( int index, int capacity, int[] weights, int[] values ){

        //Base condition
        //Think of the smallest valid input
        if( capacity == 0 ){
            return 0;
        }

        if( index < 0 ){
            return 0;
        }

        if( weights[index] > capacity ){
            //Can't pick this item as the weight is larger than the capacity
            //Move on to the next item
            return doKnapsack(index - 1, capacity, weights, values );

        }else{
            //We can pick this item and have 2 choices
            //a. Pick this item
            //b. Can pick but won't in case the next item offer better value
            //We pick the one which returns max value.
            int valueNotPicked = doKnapsack(index - 1, capacity, weights, values );
            int valuePicked = values[index] + doKnapsack(index - 1, capacity - weights[index], weights, values );

            return Math.max(valuePicked, valueNotPicked);
        }

    }



    public static void main( String[] args ){
        System.out.println( knapsack( 7, new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7} ));
    }

}
