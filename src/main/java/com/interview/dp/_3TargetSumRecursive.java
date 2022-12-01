package com.interview.dp;

//https://leetcode.com/problems/target-sum/

public class _3TargetSumRecursive {

    public static int findTargetSumWays( int targetSum, int[] numbers ){
        return doTargetSum( 0, targetSum, numbers );
    }


    private static int doTargetSum( int index, int targetSum, int[] numbers ){

        if( targetSum == 0 ){
            return 1;
        }

        if( targetSum < 0 || index >= numbers.length ){
            return 0;
        }

        if( numbers[index] > targetSum ){
            return doTargetSum( index+1, targetSum, numbers );

        }else{
            int unSelected = doTargetSum( index+1, targetSum, numbers );
            int selected = doTargetSum( index+1, targetSum-numbers[index], numbers );

            return Math.max( unSelected, selected );
        }


    }


    public static void main( String[] args ){
        System.out.println( findTargetSumWays( 3, new int[]{1,1,1,1,1}) );
    }


}
