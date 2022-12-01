package com.interview.mlp;


public class ProductDefect_MaximalSquare {

    /**
     *  For a 5x5 matrix, dp table is 6x6. Row 0 and col 0 is set with 0s.
     *
     *  1 0 1 1 1            0  0  0  0  0  0
     *  1 0 1 1 1    ===>    0  1  0  1  1  1
     *  1 1 1 1 1            0  1  0  1  2  2
     *  1 0 0 1 0            0  1  1  1  2  3
     *                       0  1  0  0  1  0
     *
     *  - We fill the dpTable using the following method:
     *  - Start from [1, 1] and check the three directions (above, left, and diagonally) and take their min value.
     *  - If the min value is 1, then we know that all values in these directions were 1! Our matrix can expand, we add 1 to it and store in dpTable
     *  - If the min value is 0, then there is a 0 in one of these directions, we can't expand.
     */

    public int maximalSquare( char[][] matrix ){

        int maxLength = 0;
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][] dpTable = new int[rowLength+1][colLength+1];

        for( int rowIndx=1; rowIndx <= rowLength; rowIndx++ ){
            for( int colIndx=1; colIndx <= colLength; colIndx++ ){

                char value = matrix[rowIndx-1][colIndx-1];
                if( value == '1') {
                    int above= dpTable[rowIndx-1][colIndx];
                    int left = dpTable[rowIndx][colIndx-1];
                    int diag = dpTable[rowIndx-1][colIndx-1];

                    dpTable[rowIndx][colIndx] = 1 + Math.min( above, Math.min(left, diag) );
                    maxLength = Math.max(maxLength, dpTable[rowIndx][colIndx]);
                }
            }
        }

        return maxLength * maxLength;

    }

}
