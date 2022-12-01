package com.interview.arrays;

import java.util.Arrays;

public class RemoveDuplicates {


    /**
     * Given an integer array sorted in non-decreasing order.
     * Remove the duplicates in-place such that each unique element appears only once.
     * The relative order of the elements should be kept the same.
     */

    //Input     [4, 4, 8]
    //Output:   2 Changes input to [4, 8, 8]
    public int removeDuplicates( int[] nums ){
        if( nums.length == 0 ) return 0;

        //We need to start checking for duplicates from index 1
        int startIndex = 1;

        //Since numbers are sorted, dups will fall next to each other
        for( int num : nums ){
            //If curr number is greater than the previous, copy it start index.
            if( num > nums[startIndex - 1] ){
                nums[startIndex++] = num;
            }
        }

        System.out.println(Arrays.toString(nums) );
        return startIndex;

    }


    public static void main(String[] args) {
        System.out.println("Result: " + new RemoveDuplicates().removeDuplicates(new int[]{4, 4, 8}) );
    }


}
