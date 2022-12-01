package com.interview.dp;

import java.util.HashMap;
import java.util.Map;


public class _1SubsetSumRecursive {

    //Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
    public static boolean isSubsetSum( int[] numbers, int sum ){
        Map<String, Boolean> map = new HashMap<>();
        return doSubsetSum( numbers.length-1, numbers, sum, map );
    }

    private static boolean doSubsetSum( int index, int[] numbers, int sum, Map<String, Boolean> map ){

        if( sum == 0 ){
            return true;
        }

        if( index < 0 || sum < 0 ){
            return false;
        }

        String key = sum + "|" + index;
        if( map.containsKey(key) ) {
            return map.get(key);
        }

        if( numbers[index] > sum ){
            map.put(key, doSubsetSum(index-1, numbers, sum, map));
        }else {
            boolean notSelected = doSubsetSum(index - 1, numbers, sum, map);
            boolean selected = doSubsetSum(index - 1, numbers, sum - numbers[index], map);

            map.put(key, (notSelected || selected));
        }

        return map.get(key);
    }


    public static void main( String[] args ){
        System.out.println( isSubsetSum( new int[]{ 7, 3, 2, 5, 8},  14 ) );
    }


}
