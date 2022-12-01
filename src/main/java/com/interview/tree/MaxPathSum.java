package com.interview.tree;

import com.interview.util.TreeNode;

public class MaxPathSum {
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum( TreeNode root ){
        findMaxPathSum( root );
        return maxPathSum;
    }

    private int findMaxPathSum( TreeNode root ){
        if( root == null ) return 0;

        int leftSum = findMaxPathSum( root.left );
        int rightSum = findMaxPathSum( root.right );

        //compare leftSum + rool val with rightSum + root.val to select which values to send further
        int maxTillNow = Math.max(leftSum + root.val, rightSum + root.val);

        // if the root value is greater than any of the path
        maxTillNow = Math.max(root.val, maxTillNow);

        //if root+left+rt is greater than any of the max till now
        int tempMax = Math.max(maxTillNow, leftSum + rightSum + root.val);

        maxPathSum = Math.max(tempMax, maxPathSum);

        return maxTillNow;
    }

}
