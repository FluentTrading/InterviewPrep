package com.interview.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestPalindromeSubstring {

    //Given a word, return the longest palindromic substring in it.
    public String longestSubstringPalindrome( String word ){

        Map<Character, Integer> freqMap = new HashMap<>();
        for( char c : word.toCharArray() ){
            freqMap.put( c, freqMap.getOrDefault(c, 0) + 1 );
        }

        int oddFreqCount = 0;
        for( int count : freqMap.values() ){
            if(count % 2 != 0 ){
                oddFreqCount++;
            }
        }

        if( oddFreqCount == 0 ){
            //All frequencies are even, whole word can be a palindrome
            return word;
        }else{
            //There are some frequencies with odd count
            //But there can only be 1 char with odd frequency in a palindrome (middle one)
            return word.substring(oddFreqCount, word.length()-1);
        }

    }


    public static void main(String[] args) {
        LongestPalindromeSubstring s = new LongestPalindromeSubstring();
        System.out.println( s.longestSubstringPalindrome( "babad" ) );





    }



}
