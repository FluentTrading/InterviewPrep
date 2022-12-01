package com.interview.dp;

import java.util.Arrays;


public class _Knapsack_0_2_BottomUp_Tabulation {

    public static int knapsack( int capacity, int[] weights, int[] values ){
        System.out.println( "Capacity: " + capacity );
        System.out.println( "Weights: " + Arrays.toString(weights) );
        System.out.println( "Values: " + Arrays.toString(values) );

        int numberOfElements = values.length;
        int[][] dp = new int[numberOfElements+1][capacity+1];

        for( int row=0; row<numberOfElements+1; row++ ){
            for( int col=0; col<capacity+1; col++ ){

                if( row == 0 || col == 0 ){
                    dp[row][col] = 0;
                }else{

                    if( weights[row-1] > capacity ){
                        dp[row][col] = dp[row-1][col];
                    }else{
                        int notSelected = dp[row-1][col];
                        int selected = values[row-1] + dp[row-1][capacity-weights[row-1]];
                        dp[row][col] = Math.max( notSelected, selected);
                    }

                }
            }
        }

        return dp[numberOfElements][capacity];
    }



    public static void main( String[] args ){
        System.out.println( knapsack( 7, new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7} ));
    }

}
