package com.interview.matrix;

import java.util.*;


public class RottingOranges {

    //TODO: Solve using DFS
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int fresh_cnt = 0;
        Queue<int[]> rotten = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    rotten.add(new int[]{r, c});

                } else if (grid[r][c] == 1) {
                    ++fresh_cnt;
                }
            }
        }

        System.out.println("Fresh count: " + fresh_cnt);

        // keep track of minutes passed.
        if(fresh_cnt == 0) return 0;
        int minutes_passed = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        //If there are rotten oranges in the queue and there are still fresh oranges in the grid keep looping
        while( !rotten.isEmpty() && fresh_cnt > 0 ){

            //update the number of minutes passed
            //it is safe to update the minutes by 1, since we visit oranges level by level in BFS traversal.
            ++minutes_passed;
            int size = rotten.size();

            for( int i=0 ;i <size; i++ ){
                int[] pop = rotten.poll();

                for (int[] direction : directions) {
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

                    //# update the fresh oranges count
                    --fresh_cnt;

                    //mark the current fresh orange as rotten
                    grid[xx][yy] = 2;

                    //# add the current rotten to the queue
                    rotten.add(new int[]{xx, yy});

                }

            }

            //iterate through rotten, popping off the (row, col) that's currently in rotten
            //we don't touch the newly added (row, col) that are added during the loop until the next loop

            //# process rotten oranges on the current level

        }

        //if fresh is not empty, then there is an orange we were not able to reach 4-directionally

        return fresh_cnt == 0 ? minutes_passed : -1;

    }

    public static void main( String[] args ){
        RottingOranges count = new RottingOranges();
        int num = count.orangesRotting( new int[][]{
                { 2, 1, 1},
                { 1, 1, 0},
                { 0, 1, 1}
        });

        System.out.println(num);
    }

}
