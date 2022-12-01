package com.interview.mlp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaysToSum {


    public List<List<Integer>> combinationSum(int k, int target ){
        int[] nums = new int[k];
        for( int i=1; i<=k; i++ ){
            nums[i-1] = i;
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        findCombinationSum( 0, target, nums, new ArrayList<>(), result);

        return result;
    }


    private void findCombinationSum( int indx, int target, int[] nums, List<Integer> current, List<List<Integer>> result ){

        if( target < 0 ){
            return;

        }else if( target == 0 ){
            result.add( new ArrayList<>(current) ); //Combo sum found

        }else{
            for( int i = indx; i < nums.length; i++ ){
                current.add(nums[i]);
                // not i + 1 because we can reuse same elements
                findCombinationSum(i, (target - nums[i]), nums, current, result );
                current.remove(current.size() - 1);
            }
        }
    }

}
