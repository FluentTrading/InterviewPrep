package com.interview.dp;

public class ClimbingStairs {

    //Can climb either 1 step or 2 steps at a time.
    //How many ways to climb n steps

    //Like solving fibonacci sequence
    public int climbStairs( int n ){
        if( n <= 0 ) return 0;
        if( n == 1 ) return 1;
        if( n == 2 ) return 2;

        int[] steps = new int[n+1];
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;

        //To get to step 3, count the ways to get to step 1 + ways to get to step 2
        for( int i=3; i<=n; i++ ){
            steps[i] = steps[i-1] + steps[i-2];
        }

        return steps[n];

    }


}
