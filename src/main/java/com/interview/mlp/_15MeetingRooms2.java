package com.interview.mlp;

import java.util.Arrays;

public class _15MeetingRooms2 {



    public int minMeetingRooms( int[][] intervals ){

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for( int i=0; i<intervals.length; i++ ){
            int[] interval = intervals[i];
            start[i] = interval[0];
            end[i] = interval[1];
        }

        Arrays.sort(start);
        Arrays.sort(end);


        int roomCount = 0;
        int endIndx = 0;

        for( int i=0; i<start.length; i++ ){
            //If a meeting starts before earliest end time, we need a new room
            if( start[i] < end[endIndx] ){
                ++roomCount;
            }else{
                //If a meeting starts after the earliest end time, we can reuse a previous room
                ++endIndx;
            }
        }

        return roomCount;
    }


}
