package com.interview.mlp;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _15MeetingRooms2 {


    //Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
    public int minMeetingRooms( int[][] intervals ){

        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //Use a min heap ordered by end time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);

        for( int i = 1; i < intervals.length; i++ ){
            int[] currInterval = intervals[i];

            //Current meeting starts after the highest end time
            if( currInterval[0] >= minHeap.peek() ){
                minHeap.poll();
            }

            minHeap.offer(currInterval[1]);
        }

        return minHeap.size();

    }

}
