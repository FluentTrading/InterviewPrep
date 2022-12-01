package com.interview.mlp;

import java.util.*;

public class FunWithAnagrams {

    public static String[] removeAnagrams( String[] words ){

        List<String> result = new ArrayList<>();
        Set<String> found = new HashSet<> ();

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


    public static void main(String[] args) {
        System.out.println( Arrays.toString(removeAnagrams( new String[]{"code", "doce", "ecod", "framer", "frame"})));
    }

}
