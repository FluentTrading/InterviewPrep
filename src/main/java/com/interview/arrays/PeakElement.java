package com.interview.arrays;

public class PeakElement {


    //A peak element is an element that is strictly greater than its neighbors.
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
