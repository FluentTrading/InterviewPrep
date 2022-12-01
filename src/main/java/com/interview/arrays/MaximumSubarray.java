package com.interview.arrays;

import java.util.Arrays;

public class MaximumSubarray {

    public int maxSubArray( int[] nums ){

        int currSum = nums[0];
        int maxSum = currSum;

        for( int i=1; i<nums.length; i++ ){
            //Adding the next number either makes currSum:
            //Larger : We add it and update currSum
            //Smaller: We cannot include this number, therefore we drop the previous number and start from here.
            currSum = Math.max( nums[i], currSum + nums[i] );
            maxSum = Math.max(currSum, maxSum );
        }

        return maxSum;

    }


    //We can have 3 cases:
    //1. All numbs are positive, then we just take the product of all numbers
    //2. Positive and negative numbers: We use two pointer to take product from left side and right side
    //3. Has 0, is we find 0, we reset it to 1
    public int maxProductSubarray( int[] nums ){
        int leftProduct  = 1;
        int rightProduct = 1;
        int maxProduct   = nums[0];

        //compute product from left and right hand side and keep updating the max
        for( int i=0; i<nums.length; i++ ){
            leftProduct  = (leftProduct == 0) ? 1 : leftProduct;
            leftProduct  = leftProduct * nums[i];

            rightProduct = (rightProduct == 0) ? 1 : rightProduct;
            rightProduct = rightProduct * nums[nums.length-1-i];

            maxProduct   = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }

        return maxProduct;

    }


    /**
     * Given an integer array nums and an integer K,
     * The task is to find the maximum sum such that for every two consecutive numbers in the subsequence,
     * nums[i] and nums[j], where i < j, the condition j – i <= K is satisfied.
     *
     */
    //Given an integer array nums, find the subarray which has the largest sum and return its sum.
    //30, -5, 3, 4
    public static int maxSubArrayWithCondition( int[] nums ){
        System.out.println(Arrays.toString(nums) );

        int currSum = nums[0];
        int maxSum = currSum;

        for( int i=1; i<nums.length; i++ ){
            //We add the next number to CurrSum:
            //Then we either keep both OR we just take the number
            currSum = Math.max( currSum + nums[i], nums[i] );
            maxSum = Math.max(currSum, maxSum );

            System.out.println(i + " => Curr: " + currSum + ", Max: " + maxSum );
        }

        return maxSum;
    }


}
