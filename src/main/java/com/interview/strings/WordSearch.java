package com.interview.strings;

public class WordSearch {


    //Given a char board and a string word, return true if word exists in the grid.
    //The word can be constructed from letters of sequentially adjacent cells,
    // where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

    public boolean search( char[][] board, String word ){

        for( int row=0; row< board.length; row++ ){
            for( int col=0; col< board[row].length; col++ ) {
                if( doSearchForWord( 0, row, col, word, board) ){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean doSearchForWord( int index, int row, int col, String word, char[][] board ){

        if( index == word.length() ){
            return true;
        }

        //Bounds check
        if( row < 0 || row >= board.length || col < 0 || col >= board[row].length ){
            return false;
        }

        //No match
        if( board[row][col] != word.charAt(index) ){
            return false;
        }

        //Already visited
        if(board[row][col] == '*'){
            return false;
        }

        //A way to indicate that this cell has been visited (else use the boolean[][] visited)
        board[row][col] = '*';

        boolean result = doSearchForWord( index+1, row, col + 1,  word, board) ||
                doSearchForWord(index+1, row + 1, col, word, board) ||
                doSearchForWord( index+1, row, col - 1, word, board) ||
                doSearchForWord( index+1, row-1, col, word, board);

        //backtrack
        board[row][col] = word.charAt(index);
        return result;
    }



}
