package com.interview.matrix;

public class _01Matrix {

    //Given a binary matrix, return the distance of the nearest 0 for each cell
    //The distance between two adjacent cells is 1.
    public int[][] updateMatrix( int[][] matrix ){

        //If cell value is 0, then distance is 0
        //If cell value is 1, then search
        //
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for( int rowIndx=0; rowIndx<matrix.length; rowIndx++ ){
            for( int colIndx=0; colIndx<matrix[0].length; colIndx++ ){
                int value = matrix[rowIndx][colIndx];
                if( value == 1 ) {
                    int distance = findDistanceToZero(rowIndx, colIndx, visited,  matrix);
                    matrix[rowIndx][colIndx] = distance;
                }
            }

        }


        return null;
    }


    private int findDistanceToZero( int rowIndx, int colIndx, boolean[][] visited, int[][] matrix ){
        if( rowIndx < 0 || rowIndx >= matrix.length || colIndx < 0 || colIndx >=matrix[0].length ){
            return 0;
        }

        if( visited[rowIndx][colIndx] ){
            return 0;
        }

        //findDistanceToZero()
        return -1;


    }

}
