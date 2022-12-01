package com.interview.misc;

public class JumpGame {


    /**
     At each step, we keep track of the furthest reachable index.
     For an index to be reachable, each of the previous indices have to be reachable.

     We iterate over each index, and If we ever encounter an index that is not reachable, we abort and return false.
     By the end, we will have iterated to the last index. If the loop finishes, then the last index is reachable.
     */

    public boolean canJump( int[] nums ){
        int reachableIndex = 0;

        for( int i=0; i<nums.length; ++i ){
            //Current jump will take me out of bounds
            if( i > reachableIndex ){
                return false;
            }

            //Furthest reachable index from this index
            reachableIndex = Math.max(reachableIndex, i + nums[i]);
        }

        return true;

    }
}
