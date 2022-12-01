package com.interview.arrays;

import java.util.Arrays;

public class RemoveDuplicates {


    public static int removeDuplicates(int[] nums) {

        int nonDupIndex =1;

        for( int indx=0; indx<nums.length-1; indx++ ){
            if( nums[indx] != nums[indx+1] ){
                System.out.print(Arrays.toString(nums) + " move [" + nums[indx+1] + "] to [" + nonDupIndex + "] => ");
                nums[nonDupIndex] = nums[indx+1];
                nonDupIndex++;
                System.out.println(Arrays.toString(nums) );
            }
        }

        System.out.println(Arrays.toString(nums) );
        return nonDupIndex;

    }


    public static void main(String[] args) {
        System.out.println("Result: " + removeDuplicates(new int[]{1, 1, 2, 2, 3, 4}) );
    }


}
