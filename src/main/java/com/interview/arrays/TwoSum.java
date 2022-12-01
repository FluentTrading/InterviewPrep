package com.interview.arrays;

import java.util.*;


public class TwoSum {

    //Return the index of the two numbers which sum up to target
    public static int[] twoSum( int[] nums, int target ){

        Map<Integer, Integer> valueMap = new HashMap<>();
        for( int i=0; i<nums.length; i++ ){
            valueMap.put( nums[i], i);
        }

        for( int i=0; i<nums.length; i++ ){
            int compliment = target - nums[i];
            Integer compliIndx = valueMap.get(compliment);
            //If the nums are was [3,2,4] and Target 6, we would find 3 and use itself to add up to 6
            //Therefore we need to ensure that indexes are different
            if( compliIndx != null && (i != compliIndx) ){
                return new int[]{i, compliIndx};
            }
        }

        return new int[]{-1, -1};
    }



    public List<List<Integer>> threeSum( int[] nums ){
        if( nums == null || nums.length == 0 ) return Collections.emptyList();

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort( nums );

        for( int i=0; i<nums.length; i++ ){
            int first = nums[i];

            int left = i+1;
            int right = nums.length-1;

            while( left < right ){
                int sec   = nums[left];
                int third = nums[right];
                int sum   = first + sec + third;

                if( sum == 0 ){
                    result.add( List.of(first, sec, third) );
                    ++left;
                    --right;

                }else if( sum < 0 ){
                    ++left;

                }else if( sum > 0 ){
                    --right;
                }

            }

        }

        return new ArrayList<>(result);

    }


}
