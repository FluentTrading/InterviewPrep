package com.interview.strings;

import java.util.*;


public class WordBreak2{

    public List<String> wordBreak( String word, List<String> wordDict ){

        List<String> result = new ArrayList<>();
        doWordBreak( word, "", result, new HashSet<>(wordDict) );

        return result;
    }


    //Runtime: O(N^2 + 2^N)
    public void doWordBreak( String word, String ans, List<String> result, Set<String> dict ){

        //If "word" in not initially empty, we will only hit this condition if:
        //We have split the string and each substring is in the dictionary.
        if( word.isEmpty() ){
            result.add( ans.trim() );
        }

        //Regular case
        //EndIndx needs to checks <= word.length since we use endIndx for substring and it needs to include the last char
        for( int endIndx=0; endIndx <= word.length(); endIndx++ ){

            String left = word.substring(0, endIndx).trim();
            String right = word.substring(endIndx).trim();

            if( dict.contains(left) ){
                String temp = (ans + " "  + left);
                doWordBreak(right, temp, result, dict);
            }

        }

    }


    public static final void main( String ... args ){
        WordBreak2 test = new WordBreak2();
        System.out.println( ">> " + test.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")) );
    }


}
