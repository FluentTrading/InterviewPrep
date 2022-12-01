package com.interview.tree;

import com.interview.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxPathSums {

    public List<List<Integer>> pathSum( TreeNode root, int targetSum ){
        List<List<Integer>> result = new ArrayList<>();
        computePathSums( root, targetSum, new ArrayDeque<>(), result );

        return result;
    }

    private void computePathSums( TreeNode root, int targetSum, Deque<Integer> current, List<List<Integer>> result ){
        if( root == null ) return;

        current.add( root.val );
        if( root.left == null && root.right == null ){
            int totalSum = current.stream().mapToInt( Integer::intValue).sum();
            if( targetSum == totalSum ){
                result.add( new ArrayList<>(current));
            }
        }

        computePathSums( root.left, targetSum, current, result );
        computePathSums( root.right, targetSum, current, result );

        current.removeLast();
    }



}
