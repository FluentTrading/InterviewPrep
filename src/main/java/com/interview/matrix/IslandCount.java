package com.interview.matrix;

public class IslandCount {


    public int numIslands( char[][] grid ){
        int count = 0;

        for( int row=0; row < grid.length; row++ ){
            for( int col=0; col < grid[0].length; col++ ){
                if( grid[row][col] == '1'){
                    ++count;
                    scanIsland( grid, row, col );
                }
            }
        }

        return count;
    }

    private void scanIsland( char[][] grid, int row, int col ){
        //Bounds check
        if( row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ){
            return;
        }

        //Found water
        if( grid[row][col] == '0'){
            return;
        }

        //If we got here, it means there is land at this cell
        //So we set it to 0 to indicate it's been visited and then scan around.
        grid[row][col] = '0';

        scanIsland( grid, row-1, col );
        scanIsland( grid, row+1, col );
        scanIsland( grid, row, col+1 );
        scanIsland( grid, row, col-1 );

    }


}
