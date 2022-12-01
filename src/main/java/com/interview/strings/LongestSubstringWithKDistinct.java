package com.interview.strings;

import java.util.*;

public class LongestSubstringWithKDistinct {


    //Given a word and an integer k, return the length of the longest substring of the word that contains at most k distinct characters.
    //[Can ONLY contain k distinct chars]

    public int lengthOfLongestSubstringKDistinct( String word, int k ){

        int leftIndx = 0;
        int rightIndx = 0;
        int distinctCount=0;
        int maxLength = 0;

        Map<Character, Integer> charFreqMap = new HashMap<>();

        while( rightIndx < word.length() ){

            char rightChar = word.charAt(rightIndx++);
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);
            if( charFreqMap.get(rightChar) == 1  ){
                ++distinctCount;
            }

            while( distinctCount > k ){
                char leftChar = word.charAt(leftIndx);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                if( charFreqMap.get(leftChar) == 0 ){
                    distinctCount--;
                }

                leftIndx++;
            }

            maxLength = Math.max(maxLength, rightIndx-leftIndx);
        }

        return maxLength;

    }


    public static void main(String[] args) {
        LongestSubstringWithKDistinct l  = new LongestSubstringWithKDistinct();
        //3
        System.out.println( l.lengthOfLongestSubstringKDistinct("eceba", 2) );
    }


}
