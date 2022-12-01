package com.interview.mlp;

public class ClimbStairs_DecodeWays_UniquePaths {


    //Can climb either 1 step or 2 steps at a time.
    //How many ways to climb n steps
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


    //"12"
    public int numDecodings( String s ){
        if( s == null || s.isBlank() || s.startsWith("0") ) return 0;

        if( s.length() == 0 ) return 1;
        if( s.length() == 1 ) return 1;

        int[] ways = new int[s.length() +1];
        ways[0] = 1;
        ways[1] = 1;

        //How to handle input like 10"
        //where len = 2 but only "10" has a meaningful decode not "01"
        for( int i=2; i<=s.length(); i++ ){
            ways[i] = ways[i-1] + ways[i-2];
        }

        return ways[s.length()];

    }


    public int uniquePaths( int m, int n ){
        int[][] grid = new int[m][n];

        for( int rowIndx = 0; rowIndx <m; rowIndx ++ ){
            for( int colIndx = 0; colIndx <n; colIndx ++ ){

                if( rowIndx == 0 || colIndx == 0 ){
                    grid[rowIndx][colIndx] = 1; //Only 1 way available from [0,0], either down or right

                }else{
                    //To get to [rowIndx, colIndx], you have to come from 1 row above (came down) OR by one col left (came right)
                    int waysOfComingFromRowUp     = grid[rowIndx-1][colIndx];
                    int waysOfComingFromColLeft   = grid[rowIndx][colIndx-1];
                    grid[rowIndx][colIndx] = waysOfComingFromRowUp + waysOfComingFromColLeft;
                }
            }
        }

        //Bottom right corner
        return grid[m-1][n-1];

    }


}
