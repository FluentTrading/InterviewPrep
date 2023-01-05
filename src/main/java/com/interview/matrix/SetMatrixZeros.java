package com.interview.matrix;

import java.util.*;

public class SetMatrixZeros {

    //Given a matrix, if an element is 0, set its entire row and column to 0. Must do it in place.

    /**
     * Runtime  : O(M*N)
     * Space    : O(M+N) (can be just M if we use only one set and reuse it!
     *
     * Iterate over the matrix and record rows and cols where the value is 0.
     * Iterate again and set value to 0, if rowIndx or colIndx is found in rowWithZero/colWithZero set.
     */
    public void setZeroes( char[][] matrix ){
        System.out.println("Input:\n" + Arrays.deepToString(matrix) );
        Set<Integer> rowWithZero = new HashSet<>();
        Set<Integer> colWithZero = new HashSet<>();

        for( int rowIndx=0; rowIndx<matrix.length; rowIndx++ ){
            for( int colIndx=0; colIndx<matrix[0].length; colIndx++ ){
                if( matrix[rowIndx][colIndx] == '0'){
                    rowWithZero.add(rowIndx);
                    colWithZero.add(colIndx);
                }
            }
        }

        for( int rowIndx=0; rowIndx<matrix.length; rowIndx++ ){
            for( int colIndx=0; colIndx<matrix[0].length; colIndx++ ){
                if( rowWithZero.contains(rowIndx) ){
                    matrix[rowIndx][colIndx] = '0';
                }

                if( colWithZero.contains(colIndx) ){
                    matrix[rowIndx][colIndx] = '0';
                }

            }
        }

        System.out.println("Output:\n" + Arrays.deepToString(matrix) );

    }


    public static void main( String[] args ){
        SetMatrixZeros matrix0 = new SetMatrixZeros();
        matrix0.setZeroes( new char[][]{
                { '1', '1', '1'},
                { '1', '0', '1'},
                { '1', '1', '1'}
        });
    }

}
