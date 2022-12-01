package com.interview.misc;

import java.util.Arrays;

public class Fibonacci {

    //0, 1, 1, 2, 3, 5, 8
    //Sum of previous 2 numbers


    public static int fibonacci1( int num ){
        if( num < 1 ){
            return 0;
        }

        //0, 1, 1, 2, 3, 5, 8
        int first = 0;
        int second = 1;

        for( int i=2; i<num; i++ ){
            int next = first + second;

            first = second;
            second = next;
        }

        return second;
    }


    public static int fibonacci( int num ){
        if( num < 1 ){
            return 0;
        }

        int[] arr = new int[num+1];
        arr[0] = 0;
        arr[1] = 1;

        for( int i=2; i<=num; i++ ){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(Arrays.toString(arr));

        return arr[num-1];

    }


    public static void main( String[] args ){
        System.out.println( fibonacci(6));
        System.out.println( fibonacci1(6));
    }


}
