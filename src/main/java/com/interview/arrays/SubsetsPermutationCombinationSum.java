package com.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsPermutationCombinationSum {


    /**
     * Given an array of distinct integers candidates and a target,
     * return a list of all unique combinations of numbers whose sum equals the target.
     */

    //Find every subset, sum them and see it equals the target
    public List<List<Integer>> combinationSum( int[] nums, int target ){
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


    //------------------------------------------------------------------------------------------------------------------
    public List<List<Integer>> subsets( int[] nums ){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(0, nums, new ArrayList<>(), result );

        return result;
    }

    private void findSubsets( int start, int[] nums, List<Integer> current, List<List<Integer>> result ){
        result.add( new ArrayList<>(current) );

        for( int i = start; i < nums.length; i++ ){
            current.add(nums[i]);
            findSubsets( i + 1, nums, current, result );
            current.remove(current.size() - 1);
        }
    }


    //------------------------------------------------------------------------------------------------------------------
    public List<List<Integer>> permutation( int[] nums ){
        List<List<Integer>> result = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        findPermutation(nums, new ArrayList<>(), result);

        return result;
    }

    private void findPermutation( int [] nums, List<Integer> current, List<List<Integer>> result){
        if( current.size() == nums.length ){
            result.add(new ArrayList<>(current));

        }else{
            for( int i = 0; i < nums.length; i++ ){
                if( current.contains(nums[i]) ) continue; // element already exists, skip

                current.add(nums[i]);
                findPermutation(nums, current, result);
                current.remove(current.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        SubsetsPermutationCombinationSum s = new SubsetsPermutationCombinationSum();
        System.out.println( s.combinationSum( new int[]{1, 2}, 8 ) );
    }

}
