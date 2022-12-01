package com.interview.dp;

import java.util.Arrays;


public class _Knapsack_0_1_TopDown_Memoized {

    public static int knapsack( int capacity, int[] weights, int[] values ){
        System.out.println( "Capacity: " + capacity );
        System.out.println( "Weights: " + Arrays.toString(weights) );
        System.out.println( "Values: " + Arrays.toString(values) );

        int[][] dp = new int[values.length+1][capacity+1];
        Arrays.stream(dp).forEach( a -> Arrays.fill(a, -1));
        return doKnapsack( weights.length-1, capacity, weights, values, dp );
    }


    private static int doKnapsack( int index, int capacity, int[] weights, int[] values, int[][] dp ){

        //Base condition
        //Think of the smallest valid input
        if( capacity == 0 ){
            return 0;
        }

        if( index < 0 ){
            return 0;
        }

        if( dp[index][capacity] != -1){
            return dp[index][capacity];
        }

        if( weights[index] > capacity ){
            //Can't pick this item as the weight is larger than the capacity
            //Move on to the next item
            dp[index][capacity] = doKnapsack(index - 1, capacity, weights, values, dp);

        }else{
            //We can pick this item and have 2 choices
            //a. Pick this item
            //b. Can pick but won't in case the next item offer better value
            //We pick the one which returns max value.
            int valueNotPicked = doKnapsack(index - 1, capacity, weights, values, dp);
            int valuePicked = values[index] + doKnapsack(index - 1, capacity - weights[index], weights, values, dp);

            dp[index][capacity] = Math.max(valuePicked, valueNotPicked);
        }

        return dp[index][capacity];

    }



    public static void main( String[] args ){
        System.out.println( knapsack( 7, new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7} ));
    }

}
