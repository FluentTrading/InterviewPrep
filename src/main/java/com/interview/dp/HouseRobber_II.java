package com.interview.dp;

import java.util.Arrays;

public class HouseRobber_II {

    /**
     * Same as HouseRobberI but we cant rob the first and last house together
     *
     * Run the solution twice:
     * a) Every house except first
     * b) Every house except last
     * c) Then take the max of a and b
     */

    public static int robHouse( int[] nums ){
        if( nums.length == 0 ){
            return 0;
        }

        if( nums.length == 1 ){
            return nums[0];
        }

        return Math.max( robHouseI( Arrays.copyOfRange(nums, 0, nums.length-1)),
                robHouseI(Arrays.copyOfRange(nums, 1, nums.length)) );

    }

    //Exact same as ron house 1
    public static int robHouseI( int[] nums ){

        int[] dp = new int[nums.length];

        dp[0] = nums[0];                    //Can only ron first house
        dp[1] = Math.max(nums[0], nums[1]); //Max of robbing first and second house

        int result = dp[1]; //Set to the max result thus far

        for( int i=2; i<nums.length; i++ ){
            //Either we ron the previous house OR we rob this house and the two previous one.
            dp[i] = Math.max( dp[i-1], (nums[i] + dp[i-2]) );
            result = Math.max(result, dp[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        int[] n = {1, 2, 3, 1};
        System.out.println( "HouseRob II " + Arrays.toString(n) + " = " + robHouse(n));
    }

}