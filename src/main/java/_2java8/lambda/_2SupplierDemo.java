package _2java8.lambda;


import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.function.Supplier;

public class _2SupplierDemo {

    /**
     * Produces an object without taking any arguments.
     *
     */
    static Supplier<String> currentTimeSupplier = ( () -> "Now is " + Instant.now(Clock.system(ZoneId.systemDefault())));

    public static String getNow( ){
        return currentTimeSupplier.get();
    }

     public static void main( String[] args ){
         System.out.println("Now: " + getNow());
     }

}
