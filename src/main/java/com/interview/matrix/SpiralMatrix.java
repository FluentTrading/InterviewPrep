package com.interview.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix ){

        List<Integer> result = new ArrayList<>();

        int startRow = 0;
        int endRow = matrix.length-1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        int direction = 0;

        while( startRow <= endRow && startCol <= endCol ){

            switch( direction ){

                case 0: //RIGHT
                    for(int col = startCol; col <= endCol; col++){
                        result.add(matrix[startRow][col]);
                    }
                    startRow++;
                    break;

                case 1: //DOWN
                    for( int row = startRow; row <=endRow; row++ ){
                        result.add(matrix[row][endCol]);
                    }
                    endCol--;
                    break;

                case 2://LEFT
                    for(int col = endCol; col >= startCol; col --){
                        result.add(matrix[endRow][col]);
                    }
                    endRow--;
                    break;

                case 3://UP
                    for(int row = endRow; row >= startRow; row--){
                        result.add(matrix[row][startCol]);
                    }
                    startCol++;
                    break;

            }

            direction = (++direction) % 4;
        }

        return result;

    }

}
