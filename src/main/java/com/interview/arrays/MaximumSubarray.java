package com.interview.arrays;


public class MaximumSubarray {

    //Given an array, find the subarray which has the largest sum and return its sum.
    public int maxSubarray( int[] nums ){

        int currSum = nums[0];
        int maxSum = currSum;

        for( int i=1; i<nums.length; i++ ){
            //At index i, we have two choices:
            //a) Either use this number and add to currSum (hopefully that makes currSum larger)
            //b) We cannot include this number, therefore we drop the previous number and start from here.
            currSum = Math.max( nums[i], currSum + nums[i] );
            maxSum = Math.max(currSum, maxSum );
        }

        return maxSum;
    }

    //Given an array, find a subarray that has the largest product, and return the product.
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


}
