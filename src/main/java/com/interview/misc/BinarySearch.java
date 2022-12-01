package com.interview.misc;


public class BinarySearch {


    //NOTE: Check your solution with two number input. This will tell you if you need to use lo <= hi
    public int binarySearch( int[] nums, int target ){

        int lo = 0;
        int hi = nums.length -1;

        while( lo <= hi ) {

            int midIndx = lo + (hi - lo) / 2;
            int midValue = nums[midIndx];

            if (target == midValue) {
                return midIndx;

            } else if (target < midValue) {
                hi = midIndx - 1;

            } else {
                lo = midIndx + 1;
            }

        }

        return -1;

    }

}
