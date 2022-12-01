package _2java8.lambda;

import java.util.List;


public class _5MethodReference1 {

    /**
     * Method references are a special type of lambda expressions.
     * They're often used to create simple lambda expressions by referencing existing methods.
     *
     * There are four kinds of method references:
     *
     * Static methods
     * Instance methods of particular objects
     * Instance methods of an arbitrary object of a particular type
     * Constructor
     *
     */

    public static void staticMethodReference( List<Integer> list ){
        //Usual way
        list.forEach( x -> System.out.println(x) );

        //Static method reference
        list.forEach( System.out::println );
    }


    public static void instanceMethod( List<Integer> list ){
        list.stream().forEachOrdered( System.out::println );
    }


    public static void main( String[] args ){
        List<Integer> numList = List.of(1, 2, 4, 5, 6, 8, 10, 20, 20, 100, 500 );

        staticMethodReference( numList );
     }

}
