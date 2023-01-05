package com.interview.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    /**
     * Given an array of meeting time intervals [start, end], return the minimum number of conference rooms required.
     * https://leetcode.com/problems/meeting-rooms-ii/
     *
     * Intuition: [0,30] [5,10] [15,20]
     * [0, 30]
     * [5, 10]  [15, 20]
     *
     * For every non-overlapping interval, place it after the previous interval ends.
     */

    public int minMeetingRooms( int[][] intervals ){

        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        System.out.println( "Sorted: " + Arrays.deepToString(intervals));

        //Use a min heap ordered by end time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);

        // Intervals: [0,30] [5,10] [15,20]
        // Room Allocation (2)
        // [0 -------------------------------30]
        //      [5------10]     [15---20]

        for( int i = 1; i < intervals.length; i++ ){
            //Current meeting starts after the highest end time
            if( intervals[i][0] >= minHeap.peek() ){
                System.out.println( "Removing " + minHeap.peek() );
                minHeap.poll();
            }

            minHeap.offer(intervals[i][1]);
            System.out.println(minHeap );
        }

        return minHeap.size();

    }


    public static void main( String[] args ){
        MeetingRooms2 room = new MeetingRooms2();
        int minMeetingRoom = room.minMeetingRooms( new int[][]{
                {0, 30 },
                {5, 10 },
                {15, 20}
        });

        System.out.println( minMeetingRoom );
    }

}
