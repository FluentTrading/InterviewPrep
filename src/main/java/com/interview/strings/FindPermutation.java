package com.interview.strings;

import java.util.*;

public class FindPermutation {

    //Does s2 contain a permutation of s1
    //s2 = eidbaooo, s1= ab
    //True (as ba exists in s2)

    public boolean checkInclusion( String s1, String s2 ){

        Map<Character, Integer> s1FreqMap = new HashMap<>();
        for( char c : s1.toCharArray() ){
            s1FreqMap.put(c, s1FreqMap.getOrDefault(c, 0) + 1);
        }

        int leftIndx = 0;
        int rightIndx = 0;

        while( rightIndx < s2.length() ){

            char rightChar = s2.charAt(rightIndx);
            int freqInS1 = s1FreqMap.getOrDefault(rightChar, 0);

            if( freqInS1 > 0 ){
                s1FreqMap.put(rightChar, freqInS1-1);
                ++rightIndx;

            }else{
                char leftChar = s2.charAt(leftIndx);
                s1FreqMap.put( leftChar, s1FreqMap.getOrDefault(leftChar, 0) +1);
                ++leftIndx;
            }

            if( rightIndx-leftIndx == s1.length() ){
                return true;
            }
        }


        return false;

    }

}
