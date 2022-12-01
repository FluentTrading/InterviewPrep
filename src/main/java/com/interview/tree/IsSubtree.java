package com.interview.tree;

import com.interview.util.TreeNode;

public class IsSubtree {


    //Return true if there is a subtree within root with the same structure and node values of subRoot and false otherwise.
    public boolean isSubtree(TreeNode root, TreeNode subRoot ){
        if( root == null ) return false;

        //Are the trees the same starting from here?
        if( isSameTree(root, subRoot) ) return true;

        //No, explore the left and right subtree of the root
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    //Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
    private boolean isSameTree(TreeNode root1, TreeNode root2 ){
        if( root1 == null && root2 == null ) return true;
        if( root1 == null || root2 == null ) return false;
        if( root1.val != root2.val ) return false;

        return isSameTree( root1.left, root2.left) && isSameTree( root1.right, root2.right);
    }


}
