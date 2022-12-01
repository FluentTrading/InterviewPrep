package com.interview.tree;

import com.interview.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {

    //Do an inorder traversal and ensure the numbers are sorted.
    public boolean isValidBST( TreeNode root ){
        List<Integer> list = new ArrayList<>();
        inorder( root, list );

        for( int i=0; i<list.size()-1; i++ ){
            if( list.get(i) >= list.get(i+1) ){
                return false;
            }
        }

        return true;
    }

    //Inorder   : left, root, right
    //Preorder  : root, left, right
    //Postorder : left, right, root
    private static void inorder( TreeNode node, List<Integer> list ){
        if( node == null ) return;

        inorder( node.left, list);
        list.add(node.val);
        inorder( node.right, list );
    }

}
