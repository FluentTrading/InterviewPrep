package com.interview.arrays;

public class RansomNote {


    //Same as figuring out if these two are anagrams of each other.
    //However, here we check if freq > 0 as magazine could have more chars than needed
    public boolean canConstruct( String ransomNote, String magazine ){
        int[] freqArray = new int[26];

        for( char c : ransomNote.toCharArray() ){
            int index = c - 'a'; //Ascii value of the char - Ascii value of char a
            freqArray[index] = freqArray[index] +1;
        }

        for( char c : magazine.toCharArray() ){
            int index = c - 'a';
            freqArray[index] = freqArray[index] -1;
        }

        for( int freq : freqArray ){
            if( freq > 0 ) return false;
        }

        return true;
    }

}
