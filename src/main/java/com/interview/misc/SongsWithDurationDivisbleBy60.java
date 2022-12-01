package com.interview.misc;

import java.util.*;


public class SongsWithDurationDivisbleBy60 {

    /*
        You are given a list of songs where the ith song has a duration of time[i] seconds.
        Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
        Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
     */

    public static int numPairsDivisibleBy60( int[] times ){
        Arrays.sort( times );

        int count = 0;
        Map<Integer, Integer> remainderMap = new LinkedHashMap<>();
        for( int time : times ){
            int remainder = (time % 60);
            remainderMap.put( time, remainder );
        }
        System.out.println( remainderMap );

        for( int time : times ){
            int remainder = (time % 60);
            if( remainderMap.containsKey(remainder) ){
                ++count;
            }
        }

        return count;
    }


    public static void main( String[] args ){
        System.out.println( numPairsDivisibleBy60( new int[]{30, 20, 150, 100, 40} ) );

    }


}
