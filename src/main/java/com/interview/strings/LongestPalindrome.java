package com.interview.strings;

import java.util.*;

public class LongestPalindrome {

    //Given a word, return the length of the longest palindrome that can be built with those letters.

    //Get frequencies of the chars in the word
    //Find the number of chars with odd frequencies
    //If all freq are even, then the whole word can be a palindrome
    //Else, we can tolerate 1 odd freq (it can be the middle value in palindrome), so word.length - (offCount - 1)

    public int longestPalindrome( String word ){

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
            return word.length();
        }else{
            return word.length() - (oddFreqCount - 1);
        }

    }


    //Runtime   : O(n)
    //Space     : O(1)
    //NOTE      : Another way is to clean up phrase and then keep checking first and last chars. But that will create a new String.
    public static boolean isPalindrome( String phrase ){
        System.out.println( "Input: " + phrase );

        int fIndx = 0;
        int lIndx = phrase.length() -1 ;

        while( fIndx < lIndx ){

            char firstChar = phrase.charAt(fIndx);
            char lastChar  = phrase.charAt(lIndx);

            if( !Character.isLetterOrDigit(firstChar) ){
                ++fIndx;

            }else if( !Character.isLetterOrDigit(lastChar) ){
                --lIndx;

            }else{
                if( Character.toLowerCase(firstChar) != Character.toLowerCase(lastChar) ){
                    System.out.println( firstChar + " doesn't match with " + lastChar );
                    return false;
                }else{
                    ++fIndx;
                    --lIndx;
                }
            }
        }

        return true;
    }


}
