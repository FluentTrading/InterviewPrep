package com.interview.misc;


public class IsRotation {

    //"waterbottle" is a rotation of "erbottlewat"
    public boolean isRotation( String word1, String word2 ){

        if( word1.equals(word2) ) return true;

        char[] word1Array = word1.toCharArray( );

        //Starting from 1 as starting from index to the end is same as checking the intial word
        for( int i=1; i <word1Array.length; i++ ){
            String firstChar = word1.substring(0, i);
            String restWord1 = word1.substring(i, word1.length( ));

            String rotateBy1Char = restWord1 + firstChar;
            System.out.println( "Iteration: " + i + ": " + rotateBy1Char + ", " + word2 );
            if( rotateBy1Char.equals(word2) ){
                return true;
            }
        }

        return false;
    }


}
