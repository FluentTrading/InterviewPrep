package com.interview.util;

import java.util.Arrays;
import java.util.*;

public class Tips {

    private static void indexFromChar(){
        System.out.println("\n--------------------------------------------");
        System.out.println("Getting index from a char");
        char c = 'c';
        int index = c -'a';
        System.out.println("Index of " + c + " is " + index );
    }

    private static void initializeMapSoItDoesntResize(){
        System.out.println("\n--------------------------------------------");
        System.out.println("How to size a map which will store 100 elements so it doesnt resize.");
        System.out.println("Find a number > 100 that is a power of 2. Then use (nearestNumberPowerOf2 * 4/3) + 1");
    }

    private static void reverseSortAPrimitiveArray(){
        System.out.println("\n--------------------------------------------");
        System.out.println("Reverse sorting primitive array");
        int[] array = {1, 4, 5, 9, 8, 7, 6, 5};
        System.out.println("Original: " + Arrays.toString(array));

        Arrays.sort(array);
        System.out.println("Ascending: " + Arrays.toString(array));

        int[] reverseSorted = Arrays.stream(array).boxed().sorted( Comparator.reverseOrder() ).mapToInt( Integer::intValue ).toArray();
        System.out.println("Descending: " + Arrays.toString(reverseSorted));
    }


    public static void main( String[] args ){
        indexFromChar();
        initializeMapSoItDoesntResize();
        reverseSortAPrimitiveArray();
    }

}
