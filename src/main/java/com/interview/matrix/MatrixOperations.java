package com.interview.matrix;

import java.util.Arrays;


public class MatrixOperations {


    //To rotate 90 degree clockwise, transpose and reverse the rows
    public void shiftClockwise90( int[][] matrix ){
        MatrixOperations.transpose( matrix );
        MatrixOperations.reverseMatrix( matrix );

        System.out.println("Shifted clockwise\n" + Arrays.deepToString(matrix));
    }


    //To rotate 90 degree anti-clockwise, reverse the rows and transpose
    public void shiftAntiClockwise90( int[][] matrix ){
        MatrixOperations.reverseMatrix( matrix );
        MatrixOperations.transpose( matrix );

        System.out.println("Shifted anti-clockwise\n" + Arrays.deepToString(matrix));
    }


    public static void transpose( int[][] matrix ){

        for( int rIndx=0; rIndx<matrix.length; rIndx++ ){
            //If we start cIndx=0, it will transpose it twice.
            //For e.g. when we visit [1, 2], we will transpose to [2,1]
            // //But when we visit [2, 1], we will set it back

            for( int cIndx=rIndx; cIndx<matrix[0].length; cIndx++ ){
                if( rIndx == cIndx ) continue; //Diagonal remains the same, so no need to swap

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

                int temp = row[i];
                row[i]  = row[lastIndx];
                row[lastIndx] = temp;
            }
        }

    }



    public static void main( String[] args ){

        MatrixOperations matrix = new MatrixOperations();
        int[][] data = new int[][]{
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Input\n: " + Arrays.deepToString(data));
      //  matrix.shiftClockwise90( data );
        matrix.shiftAntiClockwise90( data);
    }



}
