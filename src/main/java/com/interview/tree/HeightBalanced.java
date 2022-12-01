package com.interview.tree;

import com.interview.util.TreeNode;

public class HeightBalanced {

    //Keep finding the max depth of the tree at every node
    //If left height != right height, tree is not balanced.

    private boolean result = true;

    public boolean isBalanced( TreeNode root ){
        maxDepth(root);
        return result;
    }

    public int maxDepth( TreeNode root ){
        if( root == null || result == false ) {
            return 0;
        }

        int leftHeight  = maxDepth( root.left );
        int rightHeight = maxDepth( root.right );
        if( Math.abs(leftHeight - rightHeight) > 1 ){
            result = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);

    }

}

