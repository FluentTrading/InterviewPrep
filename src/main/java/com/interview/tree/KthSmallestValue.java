package com.interview.tree;

import com.interview.util.TreeNode;

import java.util.PriorityQueue;

public class KthSmallestValue {


    //Given the root and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
    public int kthSmallestValue(TreeNode root, int k ){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (x, y) -> (y-x));
        traverseAndAdd(root, maxHeap, k );
        return maxHeap.peek();
    }

    private void traverseAndAdd( TreeNode root, PriorityQueue<Integer> maxHeap, int k ){
        if( root == null ) return;

        if( maxHeap.size() < k ){
            maxHeap.add( root.val );
        }else{
            if( root.val < maxHeap.peek() ){
                maxHeap.remove();
                maxHeap.add( root.val );
            }
        }

        traverseAndAdd( root.left, maxHeap, k );
        traverseAndAdd( root.right, maxHeap, k );
    }




}
