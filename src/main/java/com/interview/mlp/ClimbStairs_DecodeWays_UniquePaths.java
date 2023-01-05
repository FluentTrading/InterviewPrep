package com.interview.mlp;

public class ClimbStairs_DecodeWays_UniquePaths {

    //How many ways to climb n steps if we can climb either 1 step or 2 steps at a time,
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

    public int climbStairs2( int n ){
        if( n <= 0 ) return 0;
        if( n == 1 ) return 1;
        if( n == 2 ) return 2;

        int first = 1;
        int next  = 2;

        //To get to step 3, count the ways to get to step 1 + ways to get to step 2
        for( int i=3; i<=n; i++ ){
            int curr = first + next;

            first = next;
            next = curr;
        }

        return next;
    }


    //"12"
    public int numDecodings( String word ){
        if( word.startsWith("0") ) return 0;

        int[] ways = new int[word.length() +1];
        //Only 1 way to decode an empty string
        ways[0] = 1;

        //Only 1 way to decode a string of length 1 unless it is '0'
        ways[1] = (word.charAt(0) == '0') ? 0 : 1;

        //Two ways to handle word of length 2
        //We either take the last char by itself or we append it to the previous one.
        for( int i=2; i<=word.length(); i++ ){

            //If last char is 0, then all we have is the previous number of ways
            char lastChar  = word.charAt(i - 1);
            if( lastChar == '0' ){
                ways[i] = ways[i-1];
            }

            //Last two must make a valid number (10 -26)
            String lastTwo = word.substring(i-2, i);
            int lastTwoValue = Integer.valueOf(lastTwo);
            if( lastTwoValue >= 10 && lastTwoValue <= 26 ) {
                ways[i] = ways[i - 1] + ways[i - 2];
            }
        }

        return ways[word.length()];

    }

    /**
     * There is a robot on an m x n grid initially [0][0].
     * It tries to move to the bottom-right corner [m - 1][n - 1] but can only move either down or right at any point in time.
     *
     * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     */
    public int uniquePaths( int m, int n ){
        int[][] grid = new int[m][n];

        for( int rowIndx= 0; rowIndx<m; rowIndx++ ){
            for( int colIndx= 0; colIndx<n; colIndx++ ){

                if( rowIndx == 0 || colIndx == 0 ){
                    grid[rowIndx][colIndx] = 1; //Only 1 way available from [0,0], either down or right

                }else{
                    //To get to [rowIndx, colIndx], you have to come from 1 row above (came down) OR by one column left (came right)
                    int waysOfComingFromRowUp   = grid[rowIndx-1][colIndx];
                    int waysOfComingFromColLeft = grid[rowIndx][colIndx-1];
                    grid[rowIndx][colIndx]      = waysOfComingFromRowUp + waysOfComingFromColLeft;
                }
            }
        }

        //Bottom right corner
        return grid[m-1][n-1];

    }


}
