package com.interview.tree;

import util.TreeNode;
import java.util.*;


public class RightSideView {

    //Level order iteration will always visit the right node last.
    //So, after each level order iteration, add the last element to result

    public List<Integer> rightSideView( TreeNode root ){
        if( root == null ) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while( !queue.isEmpty() ){
            int size = queue.size();

            for( int i=0; i<size; i++ ){
                TreeNode node = queue.poll();
                if( node.left != null ){
                    queue.add(node.left);
                }

                if( node.right != null ){
                    queue.add(node.right);
                }

                if( i == (size-1) ){
                    result.add(node.val);
                }
            }

        }

        return result;

    }

}
