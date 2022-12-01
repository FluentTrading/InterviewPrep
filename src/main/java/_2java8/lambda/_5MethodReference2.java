package _2java8.lambda;

import java.util.List;

public class _5MethodReference2 {

    public static class Number{

        int number;
        public Number( int number ){
            this.number = number;
            System.out.println("Creating a number " + number );
        }
    }

    public static void instanceMethodReference( List<Integer> list ){
        _5MethodReference2 test = new _5MethodReference2();

        list.stream().forEachOrdered( x -> test.printIt(x) );

        //Instance method reference where test::printIt is a consumer
        list.stream().forEachOrdered( test::printIt );


        //Constructor method reference
        list.stream().forEachOrdered( Number::new );
    }


    public void printIt( Integer value ){
        System.out.println( value );
    }


    public static void main( String[] args ){
        instanceMethodReference( List.of(1, 2, 4, 5, 6, 8, 10, 20, 20, 100, 500 ) );
     }

}
