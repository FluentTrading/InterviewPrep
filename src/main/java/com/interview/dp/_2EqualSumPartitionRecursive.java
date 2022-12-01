package com.interview.dp;

import java.util.HashMap;
import java.util.Map;

//Given an array of number, determine if it can be partitioned into two subsets such that sum of elements in both subsets is the same.

public class _2EqualSumPartitionRecursive {

    public static boolean equalSumPartition( int[] numbers ){
        Map<String, Boolean> map = new HashMap<>();

        int sum = 0;
        for( int n : numbers ){
            sum += n;
        }

        //[1. 5. 11. 5]
        //Sum = 22
        //Can ONLY split an even sum into 2 equal parts! (11, 11)
        //If Sum was 23, we can't split it evenly.
        if( sum % 2 != 0 ){
            return false;
        }

        //Now, we need to find a subset whose sum is 11 (other subset will automatically add up to 11 as the sum is 22)
        return doSubsetSum( 0, (sum/2), numbers, map );

    }

    private static boolean doSubsetSum( int index, int sum, int[] numbers, Map<String, Boolean> map ){

        if( sum == 0 ){
            return true;
        }

        if( index >= numbers.length ||  sum < 0 ){
            return false;
        }

        String key = sum + "|" + index;

        if( !map.containsKey(key) ){
            if( numbers[index] > sum ){
                boolean cantInclude = doSubsetSum(index + 1, sum, numbers, map);
                map.put( key, cantInclude);

            } else {
                boolean wontInclude = doSubsetSum(index + 1, sum, numbers, map);
                boolean willInclude = doSubsetSum(index + 1, sum - numbers[index], numbers, map);

                map.put( key, wontInclude || willInclude);
            }
        }

        return map.get(key);

    }


    public static void main( String[] args ){
        System.out.println( equalSumPartition( new int[]{1, 5, 11, 5}) );
    }


}
