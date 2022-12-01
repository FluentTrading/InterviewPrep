package com.interview.arrays;

public class RotatedArray {


    /**
     * Sorted array is rotated between 1 and n times.
     * For example, the array nums = [0,1,2,4,5,6,7] might become: [4,5,6,7,0,1,2] if it was rotated 4 times.
     *
     * Find the minimum element of this array in O(log n) time.
     */

    public int findMinInRotatedSortedArray( int[] nums ){

        int leftIndx = 0;
        int rightIndx= nums.length - 1;

        while( leftIndx < rightIndx ){
            int midIndx = (leftIndx + rightIndx) / 2;

            if( nums[midIndx] > nums[rightIndx] ){
                //Pivot must be to the right of the middle:
                leftIndx = midIndx + 1;
            }else{
                //Pivot must be at mid or to the left of mid:
                rightIndx = midIndx;
            }
        }

        //We kept squeezing from left and right, so at the end, min must be at the left indx
        return nums[leftIndx];

    }


    /**
        There is an integer array nums sorted in ascending order (with distinct values).
        Prior to being passed to your function, nums is possibly rotated at an unknown pivot index
        Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums in O(log n) time.

        nums = [4,5,6,7,0,1,2], target = 0
        Output: 4
     */
    public int searchInRotatedArray( int[] nums, int target ){

        int leftIndx = 0;
        int rightIndx = nums.length - 1;

        while( leftIndx < rightIndx ){

            int midIndx = (leftIndx + rightIndx) / 2;

            if( nums[midIndx] > nums[rightIndx] ){
                // eg. 3,4,5,6,1,2
                //smaller numbers are at the end
                if( target > nums[midIndx] || target <= nums[rightIndx] ){
                    leftIndx = midIndx + 1;
                }else{
                    rightIndx = midIndx;
                }

            } else {  // eg. 5,6,1,2,3,4
                if( target > nums[midIndx] && target <= nums[rightIndx] ){
                    leftIndx = midIndx + 1;
                }else {
                    rightIndx = midIndx;
                }
            }
        }

        return ( target == nums[leftIndx] ) ? leftIndx : -1;

    }


}
