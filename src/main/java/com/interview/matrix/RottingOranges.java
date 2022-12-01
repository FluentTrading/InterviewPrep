package com.interview.matrix;

import java.util.*;


public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        int freshCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> rottenQueue = new ArrayDeque<>();

        //Go over the grid and add coordinates of rotten, plus get a count of fresh oranges.
        for( int rowIndx = 0; rowIndx<rows; rowIndx++ ){
            for( int colIndx = 0; colIndx<cols; colIndx++ ){
                if (grid[rowIndx][colIndx] == 2) {
                    rottenQueue.add(new int[]{rowIndx, colIndx});

                }else if( grid[rowIndx][colIndx] == 1 ){
                    ++freshCount;
                }
            }
        }


        int minutes_passed = 0;
        int[][] directions = { {1,0},{-1,0},{0,1},{0,-1} };

        //Start BFS
        while( rottenQueue.isEmpty() && freshCount > 0 ){
            ++minutes_passed;

            int size = rottenQueue.size();

            for( int i=0 ;i <size; i++ ){
                int[] pop = rottenQueue.poll();

                for( int[] direction : directions ){
                    int xx = pop[0] + direction[0];
                    int yy = pop[1] + direction[1];

                    //ignore the cell if it is out of the grid boundary
                    if (xx < 0 || xx >= rows || yy < 0 || yy >= cols) {
                        continue;
                    }

                    //ignore the cell if it is empty '0' or visited before '2'
                    if (grid[xx][yy] == 0 || grid[xx][yy] == 2) {
                        continue;
                    }

                    //This orange is rotten, decrease the fresh oranges count
                    --freshCount;

                    //Mark the current fresh orange as rotten in the grid
                    grid[xx][yy] = 2;

                    //Add the current coordinate to the rottenQueue so we can traverse further
                    rottenQueue.add( new int[]{xx, yy} );

                }
            }
        }

        //If there are still some fresh oranges left, then we failed to make all of them rotten. Return -1
        return (freshCount != 0) ? -1 : (minutes_passed );

    }

}
