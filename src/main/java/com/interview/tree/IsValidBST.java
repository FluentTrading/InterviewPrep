package com.interview.tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {

    //Do an inorder traversal and ensure the numbers are sorted.
    public boolean isValidBST( TreeNode root ){
        List<Integer> list = new ArrayList<>();
        BinarySearchTree.inorder( root, list );

        for( int i=0; i<list.size()-1; i++ ){
            if( list.get(i) >= list.get(i+1) ){
                return false;
            }
        }

        return true;
    }


}
