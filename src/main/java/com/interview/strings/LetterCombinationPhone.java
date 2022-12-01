package com.interview.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//Combination = Order doesn't matter
//Permutation = Order does matter

public class LetterCombinationPhone {

    public static List<String> letterCombination( String digits){

        Map<Character, String> phoneMap = Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz");

        StringBuilder builder = new StringBuilder();

        for( char digit : digits.toCharArray() ){
            String combo = phoneMap.get(digit);
            if( combo != null ){
                builder.append(combo);
            }
        }

        String combos = builder.toString();
        System.out.println( combos );
        List<String> result = new ArrayList<>();
        for( int i=0; i<combos.length(); i++ ) {
            performCombination(i, combos, new ArrayList<>(), result);
        }

        return result;
    }


    public static void performCombination( int index, String remainingDigits, List<String> current, List<String> result ){

        //Base case

    }


    public static void main( String[] args ){
        System.out.println( letterCombination("23"));
    }

}
