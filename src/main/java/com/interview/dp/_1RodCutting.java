package com.interview.dp;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
public class _1RodCutting {


    //Given a rod of length n, a length and a profit array
    //Cut the rod is smaller pieces such that the total profit is maximized.
    public static int cutRod( int n, int[] lengths, int[] profits ){
        return performRodCutting( 0, n, lengths, profits, new HashMap<>());
    }

    private static int performRodCutting( int index, int totalLength, int[] lengths, int[] profits, Map<String, Integer> dp){

        if( totalLength == 0 ){
            return 0;
        }

        if( index >= lengths.length || totalLength < 0 ){
            return 0;
        }

        String key = totalLength + "|" + index;

        if( dp.containsKey(key) ) {
            return dp.get(key);
        }

        //Not selected
        if (lengths[index] > totalLength) {
            dp.put(key, performRodCutting(index + 1, totalLength, lengths, profits, dp));

        } else {
           //Selected (but can reuse the item (that's why no index +1)
           int notSelected = performRodCutting(index + 1, totalLength, lengths, profits, dp);
           int selected = profits[index] + performRodCutting(index, totalLength - lengths[index], lengths, profits, dp);
           dp.put(key, Math.max(notSelected, selected));
        }

        return dp.get(key);

    }



    public static void main( String[] args ){
        System.out.println( cutRod( 8, new int[]{1, 2, 3, 4, 5, 6, 7, 8},  new int[]{1, 5, 8, 9, 10, 17, 17, 20} ) );
    }

}
