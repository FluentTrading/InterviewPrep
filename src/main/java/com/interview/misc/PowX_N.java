package com.interview.misc;


public class PowX_N {

    //Implement pow(x, n), which calculates x raised to the power n.
    public static double myPow(double x, int n) {

        //Edge case
        if( n == 0 ){
            return 1;
        }

        //Handle case when n is negative
        boolean shouldFlip = ( n < 0 );

        //If n was negative, converting to position would make int overflow
        long longN = Math.abs(n);
        double power = 1;
        for( int i=0; i<longN; i++ ){
            power = power*x;
        }

        if( shouldFlip ){
            return 1/power;
        }else{
            return power;
        }

    }


}
