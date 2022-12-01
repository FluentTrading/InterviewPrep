package com.interview.mlp;

import java.util.*;

public class LongestConsequtive {


    //Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence in O(N)
    //[100, 4, 200, 1, 3, 2]
    //4
    public int longestConsecutive( int[] nums ){

        int maxCount = 1;
        Set<Integer> numSet = new HashSet<>();
        Arrays.stream(nums).forEach( x -> numSet.add(x));

        for( int num : nums ){

            if( numSet.contains(num-1) ){
                //(num -1) exists in the set. We will wait to come across that number to start

            }else{
                //(num-1) is not in the set, this num is a starting point.
                int count= 0;
                int start = num;

                while( numSet.contains(start) ){
                    ++count;
                    start = start+1;
                }

                maxCount = Math.max( count, maxCount);
            }
        }

        return maxCount;

    }



}
