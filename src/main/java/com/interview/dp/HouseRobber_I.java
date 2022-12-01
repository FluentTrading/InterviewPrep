package com.interview.dp;

import java.util.Arrays;

public class HouseRobber_I {

    /**
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob.
     * Can't rob two consecutive houses.
     */
    public static int robHouse( int[] nums ){

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
        System.out.println( "HouseRob I " + Arrays.toString(n) + " = " + robHouse(n));
    }

}