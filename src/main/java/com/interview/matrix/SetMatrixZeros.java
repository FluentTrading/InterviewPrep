package com.interview.matrix;

import java.util.*;

public class SetMatrixZeros {

    //Given a matrix, if an element in it is 0, set its entire row and column to 0. You must do it in place.

    //Have 2 arrays, one for row and one for col. Init to 1
    //Iterate over matrix, set row and col array to 0 where value is 0
    public void setZeroes( int[][] matrix ){

        int[] rows = new int[matrix.length];
        Arrays.fill(rows, 1);

        int[] cols = new int[matrix[0].length];
        Arrays.fill(cols, 1);

        for( int rowIndx=0; rowIndx<matrix.length; rowIndx++ ){
            for( int colIndx=0; colIndx<matrix[0].length; colIndx++ ){
                int value = matrix[rowIndx][colIndx];
                if( value == 0 ){
                    rows[rowIndx] = 0;
                    cols[colIndx] = 0;
                }
            }
        }

        //Set Rows to 0 where rowIndx =0
        //Set Cols to 0 where colIndx =0
        for( int rowIndx=0; rowIndx<matrix.length; rowIndx++ ){
            for( int colIndx=0; colIndx<matrix[0].length; colIndx++ ){

                if( rows[rowIndx] == 0 ){
                    matrix[rowIndx][colIndx] = 0;
                }

                if( cols[colIndx] == 0 ){
                    matrix[rowIndx][colIndx] = 0;
                }

            }
        }

    }

}
