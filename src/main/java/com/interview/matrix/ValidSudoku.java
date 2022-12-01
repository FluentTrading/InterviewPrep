package com.interview.matrix;

import java.util.*;

public class ValidSudoku {

    public boolean isValidSudoku( char[][] board ){

        Set seen = new HashSet();

        for( int row=0; row<board.length; row++ ){
            for( int col=0; col<board[0].length; col++ ){

                char number = board[row][col];
                if( number == '.' ) continue;

                if( !seen.add(number + " in row " + row) ){
                    return false;
                }

                if( !seen.add(number + " in col " + col) ){
                    return false;
                }

                if( !seen.add(number + " in grid " + row/3 + "-" + col/3) ){
                    return false;
                }
            }
        }

        return true;
    }

}
