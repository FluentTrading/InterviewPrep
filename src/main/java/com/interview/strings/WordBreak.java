package com.interview.strings;

import java.util.*;

public class WordBreak {

    /*
    Given a word and a dictionary, can the word be segmented into a space-separated sequence of one or more dictionary words?
    Note that the same word in the dictionary may be reused multiple times in the segmentation.
    */

    public boolean wordBreak(String word, List<String> wordDict) {
        //Add all words into a hashset
        Set<String> set = new HashSet<>(wordDict);
        return doWordBreak(word, set);
    }

    private boolean doWordBreak(String word, Set<String> set) {
        if( word.isEmpty() ){
            return true;
        }

        for (int i=1; i <= word.length(); i++ ){
            if( set.contains(word.substring(0, i)) && doWordBreak(word.substring(i), set) ){
                return true;
            }

        }

        return false;
    }

}
