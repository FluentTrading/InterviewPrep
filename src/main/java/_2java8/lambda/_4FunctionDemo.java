package _2java8.lambda;

import java.util.function.Function;

public class _4FunctionDemo {

    /**
     * class of functions that takes an input and produces an output
     *
     * Function<T, R>	    R apply( T arg )
     * UnaryOperator<T>	    R apply( T arg )
     * BinaryOperator<T>	R apply( T arg1, U arg2 )
     */

    record Person(String name, int age) {}


    public static String showDetails( Person person ){
        Function<Person, String> func = ( (x) -> "Name: " + x.name + ", Age: " + x.age );
        return func.apply(person);
    }

    public static void testFunction(){
        System.out.println( "testFunction");
        showDetails( new Person("Vic", 12) );
    }


    public static void main( String[] args ){
        testFunction();
    }

}
