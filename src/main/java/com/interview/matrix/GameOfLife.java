package com.interview.matrix;

public class GameOfLife {


    public void gameOfLife( int[][] board ) {

        int[][] output = new int[board.length][board[0].length];

        for (int rIndx = 0; rIndx < board.length; rIndx++) {
            for (int cIndx = 0; cIndx < board[0].length; cIndx++) {

                int cellValue = board[rIndx][cIndx];
                int count = getNeighborCount(rIndx, cIndx, board);

                if ((cellValue == 1) && count < 2) {
                    output[rIndx][cIndx] = 0;

                } else if ((cellValue == 1) && (count == 2 || count == 3)) {
                    output[rIndx][cIndx] = 1;

                } else if ((cellValue == 1) && (count > 3)) {
                    output[rIndx][cIndx] = 0;

                } else if ((cellValue == 0) && (count == 3)) {
                    output[rIndx][cIndx] = 1;
                }
            }

        }

        for( int rIndx = 0; rIndx < board.length; rIndx++ ){
            for( int cIndx = 0; cIndx < board[0].length; cIndx++ ){
                board[rIndx][cIndx] = output[rIndx][cIndx];
            }
        }

    }


    private int getNeighborCount( int rIndx, int cIndx, int[][] board ){

        int count = 0;
        //To find value in 8 directions: left, right, top, down, top left ,top right, bottom left, bottom right
        int[][] directions ={ {0,-1},{0,1},{1,0},{1,-1},{1,1},{-1,-1},{-1,1},{-1,0} };

        for( int[] dir : directions ){
            int row = rIndx+dir[0];
            int col = cIndx+dir[1];

            if( row>=0 && row<board.length && col >=0 && col<board[0].length ){
                count += board[row][col];
            }
        }

        return count;

    }


}
