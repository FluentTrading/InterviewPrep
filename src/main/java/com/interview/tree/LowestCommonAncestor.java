package com.interview.tree;

import util.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor( TreeNode root, TreeNode p, TreeNode q ){

        int rootVal = root.val;

        //Both p and q are on the left subtree of root. We need to check the left side to find the LCA
        if( p.val < rootVal && q.val < rootVal ){
            return lowestCommonAncestor(root.left, p, q);

        //Both p and q are on the right subtree of root. We need to check the right side to find the LCA
        }else if( p.val > rootVal && q.val > rootVal ){
            return lowestCommonAncestor(root.right, p, q);

        }else{
            //This means that p and q are on the opposite sides of the root. Therefore, only root can be the LCA
            return root;
        }

    }


}
