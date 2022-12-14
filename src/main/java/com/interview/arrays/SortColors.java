package com.interview.arrays;

import java.util.*;

public class SortColors {

    /**
     * Given an array objects colored red, white, or blue.
     * Sort them in-place so that objects of the same color are adjacent in the order red, white, and blue.
     *
     */

    //Get the frequency of the colors, since we know which order they should be in, lay them out.
    public void sortColors( int[] nums ){
        Map<Integer, Integer> freqMap = new HashMap<>();
        for( int num : nums ){
            freqMap.put( num, freqMap.getOrDefault(num, 0) +1 );
        }

        int indx = 0;
        int[] colors = new int[]{0, 1, 2};
        for( int color : colors ){
            indx = colorNumbers( indx, nums, color, freqMap );
        }

    }


    private int colorNumbers( int indx, int[] nums, int color, Map<Integer, Integer> freqMap ){
        int occurrenceCount = freqMap.get(color);
        while( occurrenceCount != 0 ){
            nums[indx++] = color;
            --occurrenceCount;
        }

        return indx;
    }

}
