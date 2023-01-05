package com.interview.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SpiralMatrix {

    public List<Integer> spiralOrder( int[][] matrix ){

        List<Integer> result = new ArrayList<>();

        int topRow = 0;
        int bottomRow = matrix.length-1;
        int leftCol = 0;
        int rightCol = matrix[0].length - 1;

        int direction = 0;

        while( topRow <= bottomRow && leftCol <= rightCol ){

            switch( direction ){

                case 0: //RIGHT
                    for(int col = leftCol; col <= rightCol; col++){
                        result.add(matrix[topRow][col]);
                    }
                    ++topRow;
                    break;

                case 1: //DOWN
                    for( int row = topRow; row <=bottomRow; row++ ){
                        result.add(matrix[row][rightCol]);
                    }
                    --rightCol;
                    break;

                case 2: //LEFT
                    for(int col = rightCol; col >= leftCol; col --){
                        result.add(matrix[bottomRow][col]);
                    }
                    --bottomRow;
                    break;

                case 3: //UP
                    for(int row = bottomRow; row >= topRow; row--){
                        result.add(matrix[row][leftCol]);
                    }
                    ++leftCol;
                    break;
            }

            direction = (++direction)%4;
        }

        return result;

    }

    public static void main( String[] args ){
        SpiralMatrix matrix = new SpiralMatrix();
        int[][] data = new int[][]{
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Input\n: " + Arrays.deepToString(data));
        matrix.spiralOrder( data );
    }

}
