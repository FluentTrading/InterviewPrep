package com.interview.matrix;

public class Transpose {

    //To rotate 90 degree clockwise, transpose and reverse the rows
    public void rotate( int[][] matrix ){
        transpose( matrix );
        reverseMatrix( matrix );
    }

    public static void transpose( int[][] matrix ){

        for( int rIndx=0; rIndx<matrix.length; rIndx++ ){
            for( int cIndx=rIndx; cIndx<matrix[0].length; cIndx++ ){
                if( rIndx == cIndx ) continue;

                int value = matrix[rIndx][cIndx];
                matrix[rIndx][cIndx] = matrix[cIndx][rIndx];
                matrix[cIndx][rIndx] = value;
            }
        }
    }

    public static void reverseMatrix( int[][] matrix ){

        for( int rIndx=0; rIndx<matrix.length; rIndx++ ){
            int[] row = matrix[rIndx];

            //Reverse the row
            for( int i=0; i<(row.length/2); i++ ){
                int lastIndx = row.length-i-1;
                int first = row[i];
                row[i] = row[lastIndx];
                row[lastIndx] = first;
            }
        }

    }

}
