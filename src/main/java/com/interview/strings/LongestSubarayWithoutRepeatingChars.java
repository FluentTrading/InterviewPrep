package com.interview.strings;

import java.util.*;

public class LongestSubarayWithoutRepeatingChars {


    //Sliding window problem
    //Keep expanding the rightIndx and record char freq, then check if we have found repeating chars
    //If so, keep contracting till all the repeating chars are removed
    public int lengthOfLongestSubstring( String word ){

        int leftIndx = 0;
        int rightIndx = 0;
        int counter    =0;
        int maxLength = 0;

        Map<Character, Integer> charFreqMap = new HashMap<>();

        while( rightIndx < word.length() ){

            char rightChar = word.charAt(rightIndx++);
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);
            if( charFreqMap.get(rightChar) > 1 ){
                ++counter;
            }

            //Contract the window by removing chars from leftIndx
            //NOTE: We drop from left as that's the only way to drop chars and keep a substring.
            while( counter > 0 ){
                char charTemp = word.charAt(leftIndx);
                if( charFreqMap.get(charTemp) > 1 ){
                    --counter;
                }
                charFreqMap.put(charTemp, charFreqMap.get(charTemp)-1);
                leftIndx++;
            }

            maxLength = Math.max(maxLength, rightIndx - leftIndx);

        }

        return maxLength;

    }


    public static void main( String[] args ){
        LongestSubarayWithoutRepeatingChars l  = new LongestSubarayWithoutRepeatingChars();
        System.out.println( l.lengthOfLongestSubstring("pwwkew") );
    }

}
