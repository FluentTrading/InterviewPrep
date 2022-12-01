package com.interview.arrays;

import java.util.*;


public class InsertInterval {

    /**
     * Given non-overlapping intervals sorted in ascending order by start time.
     * You are also given an interval newInterval
     * Insert newInterval into intervals such that intervals is still sorted in ascending order
     * and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary)
     *
     * Input    : intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output   : [[1,5],[6,9]]
     */
    public int[][] insertIntervalAndMergeOverlappingIntervals( int[][] intervals, int[] newInterval ){

        List<int[]> result = new ArrayList<>();

        for( int[] slot : intervals ){

            //New interval starts after the end of this slot, slot is smaller
            if( newInterval == null || newInterval[0] > slot[1] ){
                result.add(slot);

            //New interval ends before the slot starts, newInterval is the smallest, then comes slot
            }else if( newInterval[1] < slot[0] ){
                result.add(newInterval);
                result.add(slot);
                newInterval = null;

            } else {
                //Merge as there is an overlap, pick smallest for start and highest for end
                newInterval[0] = Math.min(newInterval[0], slot[0]);
                newInterval[1] = Math.max(newInterval[1], slot[1]);
            }
        }

        if( newInterval != null ){
            result.add( newInterval );
        }

        return result.toArray(new int[result.size()][]);

    }



}
