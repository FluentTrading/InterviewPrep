package _2java8._Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    private static void printStream1( List<Integer> numbers ){
        System.out.print("Print number stream: ");
        numbers.forEach(System.out::print);
        System.out.println();
    }

    private static void printStreamSkipElements( int skipNumber, List<Integer> numbers ){
        System.out.print("Print number stream after skipping " + skipNumber + " elements: " );
        numbers.stream().skip(skipNumber).forEach(System.out::print);
        System.out.println();
    }

    private static void sumNumberStream( IntStream numbers ){
        System.out.print("Sum of numbers from given stream: ");
        System.out.println( numbers.sum() );
    }


    private static void sortPrintStrings( String[] stringArray ){
        System.out.print("Convert string array to stream, sort in reverse order and print the first element: ");
        Stream.of( stringArray ).sorted(Comparator.reverseOrder()).findFirst().ifPresent( System.out::print);
        System.out.println();
    }

    private static void filterSortPrintStrings( String[] stringArray ){
        System.out.print("Convert string array to stream, filter, sort in reverse order and print the first element: ");
        Stream.of( stringArray ).filter( s -> s.startsWith("A") || s.startsWith("G") ).sorted().forEach(System.out::print);
        System.out.println();
    }

    private static void mapAndComputeAverageOfSquares( int[] numbers ){
        System.out.print("Square the given numbers and compute its average: ");
        Arrays.stream( numbers ).map( x -> x * x ).average().ifPresent(System.out::print);
        System.out.println();
    }


    private static void mapFilterPrintNames( String[] names ){
        System.out.print("Map to lowercase, filter names and print: ");
        Arrays.stream( names )
                .map( x -> x.toLowerCase() )
                .filter( x -> x.startsWith("a"))
                .forEach( System.out::print );
        System.out.println();
    }

    private static void streamRowsFromTextFileSortFilterAndPrint( String fileName ) throws IOException {
        System.out.print("Read a txt file, sort, filter and print: ");
        Stream<String> bands = Files.lines(Paths.get(fileName));
        bands.filter( x -> x.length() > 10 ).sorted().forEach( System.out::print );
        bands.close();
        System.out.println();
    }


    private static List<String> streamRowsFromTextFileSortFilterAndCollect( String fileName ) throws IOException {
        System.out.print("Read a txt file, sort, filter and collect: ");
        Stream<String> bands = Files.lines(Paths.get(fileName));
        List<String> filteredList = bands.filter( x -> x.length() > 10 ).sorted().collect( Collectors.toList() );
        bands.close();
        System.out.print( filteredList );
        System.out.println();

        return filteredList;
    }


    //Map and FlatMap both transform an input Stream<T> to an output Stream<R>.
    //Map produces 1 output for each input value,
    //FlatMap can produce 0 or more values for each input value

    //Another way to think:
    //FlatMap is a combo of map and flat, you first apply a function to map and then flatten it.
    //Stream.map only applies a function to transform the stream without flattening the stream.
    //Consider a structure like [ [1,2,3],[4,5,6],[7,8,9] ] which has "two levels".
    //Flattening this means transforming it in a "one level" structure : [ 1,2,3,4,5,6,7,8,9 ]
    private static void flatMapSquareAndCubes( List<Integer> numbers ){
        System.out.print("Flatmap a stream of numbers to squares and cubes and get their averages: ");
        numbers.stream()
                .flatMap( x -> Stream.of((x*x), (x*x*x) ) )
                .forEach( System.out::print);
        System.out.println();
    }


    //Map and FlatMap both transform an input Stream<T> to an output Stream<R>.
    //Map produces 1 output for each input value,
    //FlatMap can produce 0 or more values for each input value

    //Another way to think:
    //FlatMap is a combo of map and flat, you first apply a function to map and then flatten it.
    //Stream.map only applies a function to transform the stream without flattening the stream.
    //Consider a structure like [ [1,2,3],[4,5,6],[7,8,9] ] which has "two levels".
    //Flattening this means transforming it in a "one level" structure : [ 1,2,3,4,5,6,7,8,9 ]
    private static void stream10( List<List<Integer>> numberList ){
        //Here we have a nested structure, we need to flatten it before filtering
        numberList.stream()
                .flatMap( x -> x.stream() )
                .filter( y -> (y%2 ==0))
                .forEachOrdered( x -> System.out.print( x + " ") );
    }


    public static void main( String[] args ) throws IOException {
        printStream1(List.of(1, 2, 4, 5, 6, 8, 11, 20, 33, 100, 501 ));
        printStreamSkipElements(3, List.of(1, 2, 4, 5, 6, 8, 11, 20, 33, 100, 501 ));
        sumNumberStream(IntStream.range(1, 100));
        sortPrintStrings( new String[]{"Polly", "Bolly", "Rolly", "Apally"});
        filterSortPrintStrings( new String[]{"Arjun", "Anjani", "Aneesh", "Hans", "Gunter"});
        mapAndComputeAverageOfSquares( new int[]{ 2, 3, 4, 5 });
        mapFilterPrintNames( new String[]{"Anjani", "Samir", "Sam", "Rose", "Jay", "Ravi", "Arjun"});

        streamRowsFromTextFileSortFilterAndPrint( "C:\\temp\\Bands.txt");
        streamRowsFromTextFileSortFilterAndCollect( "C:\\temp\\Bands.txt");

        flatMapSquareAndCubes(List.of(1, 2, 4, 6, 8, 10 ));
        stream10( List.of( List.of(1, 2, 3), List.of(4, 5, 6)) );

    }


}
