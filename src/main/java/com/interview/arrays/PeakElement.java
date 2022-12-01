package com.interview.arrays;

public class PeakElement {


    /**
     * A peak element is an element that is strictly greater than its neighbors.
     * Given an array nums, find a peak element, and return its index.
     * If the array contains multiple peaks, return the index to any of the peaks.
     *
     * Input    : nums = [1,2,3,1]
     * Output   : 2
     */

    public static int findPeakElement( int[] nums ){

        int leftIndex = 0;
        int rightIndex = nums.length-1;

        while( leftIndex < rightIndex ){
            int midIndex = (leftIndex + rightIndex)/2;

            if( nums[midIndex] > nums[midIndex+1] ){
                rightIndex = midIndex;
            }else{
                leftIndex = midIndex + 1;
            }
        }

        return leftIndex;

    }

}
