package com.interview.arrays;

public class ProductExceptSelf {


    //Create two array left and right
    //left has running product of every number < than i (where i is the curr index)
    //right has running product of every number > than i (where i is the curr index)
    public int[] productExceptSelf( int[] nums ){

        int [] left  = new int[nums.length];
        int [] right = new int[nums.length];

        // Left contains left products: left[i] = nums[0] * .... * nums[i-1]  * nums[i]
        int cumulativeLeft = 1;
        for( int i=0; i<nums.length; i++ ){
            left[i] = cumulativeLeft;
            cumulativeLeft = cumulativeLeft * nums[i];
        }

        int cumulativeRight = 1;
        for( int i=nums.length-1; i>=0; i-- ){
            right[i] = cumulativeRight;
            cumulativeRight = cumulativeRight * nums[i];
        }

        int[] result = new int[nums.length];
        for( int i=0; i<result.length; i++ ){
            result[i] = left[i] * right[i];
        }

        return result;

    }

}
