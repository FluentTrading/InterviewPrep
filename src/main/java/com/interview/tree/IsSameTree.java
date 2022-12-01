package com.interview.tree;

import com.interview.util.TreeNode;

public class IsSameTree {


    //Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
    public boolean isSameTree(TreeNode root1, TreeNode root2 ){
        if( root1 == null && root2 == null ) return true;
        if( root1 == null || root2 == null ) return false;
        if( root1.val != root2.val ) return false;

        return isSameTree( root1.left, root2.left) && isSameTree( root1.right, root2.right);
    }



}
