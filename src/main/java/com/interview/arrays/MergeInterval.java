package com.interview.arrays;

import java.util.Arrays;
import java.util.LinkedList;


public class MergeInterval {

    /**
     * Given an array of intervals [start, end], merge all overlapping intervals.
     */
    public int[][] mergeIntervals ( int[][] intervals ){

        //Sort by starting time
        Arrays.sort( intervals, (x,y) -> x[0] - y[0] );
        LinkedList<int[]> result = new LinkedList<>();

        for( int[] interval : intervals ){

            if( result.isEmpty() ){
                result.add( interval );
            }else{
                int[] previous = result.getLast();
                //Can merge if current start time is less than previous end time.
                boolean canMerge    = (interval[0] <= previous[1]);
                if( canMerge ){
                    previous[1]     = Math.max( interval[1], previous[1]);
                }else{
                    result.add( interval );
                }
            }
        }

        return result.toArray( new int[result.size()][2]);

    }



}
