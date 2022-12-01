package _2java8.lambda;

import java.util.List;
import java.util.function.Consumer;

public class _3ConsumerDemo {

    /**
     * Takes in a parameter and doesn't produce anything.
     *
     */

    record Person(String name, int age) {}

    private static final Consumer<Integer> SQUARE_CONSUMER = ( x -> System.out.println(x*x) );

    private static void squareTheNumberAndPrint( List<Integer> numbersList ){
        numbersList.stream().forEach( x -> SQUARE_CONSUMER.accept(x) );
    }


    public static void main( String[] args ){
        List<Integer> numbersList = List.of(1, 2, 4, 5, 6, 8, 10, 20, 20, 100, 500 );
        squareTheNumberAndPrint( numbersList );
    }

}
