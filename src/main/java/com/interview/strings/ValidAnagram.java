package com.interview.strings;

import java.util.*;

public class ValidAnagram {


    //Runtime:  O(X) where X is the larger length
    //Space:    O(1) We will only have 26 keys
    //NOTE:     Both words are of the same Size! If not, the frequency check should be {freq >0 return false} Can also use a Map
    public static boolean isAnagram( String first, String second ){
        int[] freqArray = new int[26];

        for( char c : first.toCharArray() ){
            int index = c - 'a'; //Ascii value of the char - Ascii value of char a
            freqArray[index] = freqArray[index] +1;
        }

        for( char c : second.toCharArray() ){
            int index = c - 'a';
            freqArray[index] = freqArray[index] -1;
        }

        for( int freq : freqArray ){
            if( freq != 0 ) return false;
        }

        return true;
    }



    //Fun with Anagrams
    public static String[] removeAnagrams( String[] words ){

        List<String> result = new ArrayList<>();
        Set<String> found = new HashSet<>();

        for( String word : words ){
            char[] tempArray = word.toCharArray();
            Arrays.sort(tempArray);
            String sortedWord = String.valueOf(tempArray);

            if( !found.contains(sortedWord) ){
                result.add(word);
                found.add(sortedWord);
            }
        }

        Collections.sort(result);

        return result.toArray( new String[result.size()]);
    }


    //Group using frequency array as Key
    public List<List<String>> groupAnagrams( String[] strs ){
        Map<int[], List<String>> map = new HashMap<>();

        for( String s : strs ){
            int[] freqCount = new int[26];
            for( char c : s.toCharArray() ){
                freqCount[c-'a'] = freqCount[c-'a'] +1;
            }

            List<String> list = map.getOrDefault(freqCount, new ArrayList<>());
            list.add( s );
            map.put(freqCount, list);
        }

        return new ArrayList<>(map.values());
    }



    //Group using sorted word as Key
    public List<List<String>> groupAnagrams1( String[] strs ){
        Map<String, List<String>> map = new HashMap<>();

        for( String s : strs ){
            char[] cars = s.toCharArray();
            Arrays.sort(cars);
            String sorted = String.valueOf(cars);
            List<String> list = map.getOrDefault(sorted, new ArrayList<>());
            list.add( s );

            map.put(sorted, list);
        }

        return new ArrayList<>(map.values());
    }


}
