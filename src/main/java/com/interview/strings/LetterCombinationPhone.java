package com.interview.strings;

import java.util.*;

//Combination = Order doesn't matter
//Permutation = Order does matter

public class LetterCombinationPhone {

    //For each digit added, remove and copy every element in the queue and add the possible letter to each element,
    //then add the updated elements back into queue again.
    //Repeat this procedure until all the digits are iterated.
    public static List<String> letterCombination( String digits ) {
        if( digits == null || digits.isBlank() ) return Collections.emptyList();

        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        LinkedList<String> result = new LinkedList<>();
        result.add("");

        while( result.peek().length() != digits.length() ){
            String remove = result.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for( char c : map.toCharArray() ){
                result.addLast(remove + c);
            }
        }

        return result;
    }


    public static void main( String[] args ){
        System.out.println( letterCombination("23"));
    }

}
