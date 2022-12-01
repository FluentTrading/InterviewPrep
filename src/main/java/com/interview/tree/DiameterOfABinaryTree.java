package com.interview.tree;

import util.TreeNode;

public class DiameterOfABinaryTree {

    //For every node, length of the diameter through it is the MaxDepth of its left subtree + MaxDepth of its right subtree.

    int maxDiameter = 0;

    public int diameterOfBinaryTree( TreeNode root ){
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth( TreeNode root ){
        if( root == null ) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }


}
