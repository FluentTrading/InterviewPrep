package com.interview.misc;


public class ReverseInteger {

    //https://leetcode.com/problems/reverse-integer

    public static int reverse( int num ){

        boolean hasSign  = num < 0;
        int startIndex = ( hasSign ) ? 1 : 0;
        String stringNum = String.valueOf(num);

        StringBuilder builder = new StringBuilder( );
        //If there is a sign, add it first
        if( hasSign ){
            builder.append( stringNum.charAt(0) );
        }

        //Reverse iterate till startIndex
        for( int i=stringNum.length()-1; i >=startIndex; i-- ){
            builder.append( stringNum.charAt(i) );
        }

        //Overflow check
        int result = 0;
        try{
            result = Integer.parseInt( builder.toString() );
        }catch( Exception e ){
            System.out.println("Overflow!");
        }

        return result;
    }


    public static void main( String[] args ){
        System.out.println( reverse( 123) );
        System.out.println( reverse( -123) );
        System.out.println( reverse( 120) );
    }

}