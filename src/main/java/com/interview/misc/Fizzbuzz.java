package com.interview.misc;

public class Fizzbuzz {

    private  static final String FIZZ       = "Fizz";
    private  static final String BUZZ       = "Buzz";
    private  static final String FIZZ_BUZZ  = "FizzBuzz";
    private  static final String BUZZ_FIZZ  = "BuzzFizz";



    public static void fizzBuzzModified( int number){

        for( int i = 1; i<= number; i++ ){

            boolean by3 = divisibleBy(i, 3 );
            boolean by5 = divisibleBy(i, 5 );

            if( by3 && by5 ) {
                System.out.println(FIZZ_BUZZ);

            }else if( by3 ){
                System.out.println(BUZZ);

            }else if( by5 ){
                System.out.println(FIZZ);

            }else if( isPrime(i) ){
                System.out.println(BUZZ_FIZZ);

            }else{
                System.out.println(i);
            }
        }

    }

    private static boolean divisibleBy( int num, int divisor ){
        return ((num % divisor) == 0);
    }

    private static boolean isPrime( int number ){
        if( number <= 1 ){
            return false;
        }

        int half = number/2;
        for( int i=2; i<=half; i++ ){
            if( (number % i) == 0 ){
                return false;
            }
        }

        return true;
    }

    public static void main( String[] args ){
        fizzBuzzModified( 12 );
    }

}
