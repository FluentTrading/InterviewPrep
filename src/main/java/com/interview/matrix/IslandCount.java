package com.interview.matrix;

import java.util.HashSet;
import java.util.Set;

public class IslandCount {

    //NOTE: This solution is the exact same for Number of Provinces (one of the test cases in Number of province is wrong)
    //https://leetcode.com/problems/number-of-provinces/

    //Runtime O(M*N)
    //Space O(M*N) for visited
    public int numIslands( char[][] grid ){
        int islandCount = 0;
        Set<String> visited = new HashSet<>();

        for( int rowIndx=0; rowIndx < grid.length; rowIndx++ ){
            for( int colIndx=0; colIndx < grid[0].length; colIndx++ ){
                if( grid[rowIndx][colIndx] == '1'){
                    islandCount += scanIsland( rowIndx, colIndx, visited, grid );
                }
            }
        }

        return islandCount;

    }


    private int scanIsland( int rowIndx, int colIndx, Set<String> visited, char[][] grid ){
        //Bounds check
        if( rowIndx < 0 || rowIndx >= grid.length || colIndx < 0 || colIndx >= grid[0].length ){
            return 0;
        }

        String position = rowIndx + ", " + colIndx;
        if( visited.contains(position) ){
            return 0;
        }

        if( grid[rowIndx][colIndx] == '0' ){
            return 0;
        }

        //Indicate this row, colIndx has been visited and then scan around.
        visited.add( position );

        scanIsland(  rowIndx, colIndx+1, visited, grid );
        scanIsland(  rowIndx, colIndx-1, visited, grid );
        scanIsland(  rowIndx+1, colIndx, visited, grid );
        scanIsland( rowIndx-1, colIndx, visited, grid );

        //Once we have scanned in all 4 directions, the result is 1 island.
        return 1;
    }


    public static void main( String[] args ){
        IslandCount count = new IslandCount();
        int num = count.numIslands( new char[][]{
                { '1', '1', '1', '1', '0'},
                { '1', '1', '0', '1', '0'},
                { '1', '1', '0', '0', '0'},
                { '0', '0', '0', '0', '0'},
        });

        System.out.println(num);
    }

}
