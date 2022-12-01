package com.interview.strings;

import java.util.*;

public class FindAllAnagrams {

    /**
     * Given two strings s and p, return an array of all the start indices of p's anagrams in s
     *
     */

    public List<Integer> findAllAnagrams( String s, String p ){

        List<Integer> result = new LinkedList<>();
        Map<Character, Integer> pFreqMap = new HashMap<>();
        for( char c : p.toCharArray() ){
            pFreqMap.put(c, pFreqMap.getOrDefault(c, 0) + 1);
        }

        int leftIndx = 0;
        int rightIndx = 0;

        while( rightIndx < s.length() ){
            //What's the frequency of this char from s in p?
            //If it is more than 1, then we continue to expand by increasing rightIndx
            char rightChar = s.charAt(rightIndx);
            int rightFreq = pFreqMap.getOrDefault(rightChar, 0);

            if( rightFreq > 0 ){
                pFreqMap.put( rightChar, rightFreq -1 ); //Denotes we have used one char from right
                rightIndx++;

            }else{
                //shrunk window
                char leftChar = s.charAt(leftIndx);
                pFreqMap.put( leftChar, pFreqMap.getOrDefault(leftChar, 0) +1);
                leftIndx++;
            }

            if( (rightIndx-leftIndx) == p.length() ){
                result.add(leftIndx);
            }

        }

        return result;
    }


    public static void main(String[] args) {
        FindAllAnagrams a = new FindAllAnagrams();
        List<Integer> result = a.findAllAnagrams( "abab", "ab");
        System.out.println(result);
    }
}
