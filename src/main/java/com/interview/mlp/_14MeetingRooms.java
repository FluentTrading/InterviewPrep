package com.interview.mlp;

import java.util.Arrays;

public class _14MeetingRooms {


    //Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

    //Runtime: O(N log N)
    public boolean canAttendMeetings( int[][] intervals ){
        if( intervals == null || intervals.length == 0 ){
            return true;
        }

        Arrays.sort( intervals, (x, y) -> (x[0] - y[0]) );

        int[] first = intervals[0];

        for( int i=1; i<intervals.length; i++ ){
            int[] next = intervals[i];
            //Next starts after ther first one ends
            if( next[0] >= first[1] ){
                first = next;
            }else{
                return false;
            }

        }

        return true;
    }


}
