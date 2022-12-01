package com.interview.tree;

import com.interview.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class BinarySearchTree{

    private TreeNode root;

    public void add( int value ){
        root = add( value, root );
    }

    private TreeNode add( int value, TreeNode node ){
        if( node == null ){
            node = new TreeNode( value );
        }else{
            if( value < root.val ){
                node.left = add( value, node.left );
            }else{
                node.right = add( value, node.right );
            }
        }

        return node;
    }


    public boolean search( int value ){
        return search( value, root );
    }


    private boolean search( int value, TreeNode node){
        if( node == null ){
            return false;
        }else{
            if( value == node.val ){
                return true;

            }else if( value < node.val ){
                return  search(value, node.left );
            }else{
                return  search(value, node.right );
            }
        }
    }


    public List<List<Integer>> levelOrder( TreeNode root ){
        List<List<Integer>> result = new ArrayList<>();
        if( root == null ) return result;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while( !queue.isEmpty() ){
            int size = queue.size();
            List<Integer> levelResult = new ArrayList<>();

            for( int i=0; i<size; i++ ){
                TreeNode node = queue.pop();
                levelResult.add(node.val);

                if( node.left != null ) queue.add( node.left );
                if( node.right != null ) queue.add( node.right );
            }

            result.add(levelResult);
        }

        return result;
    }


    //Inorder   : left, root, right
    //Preorder  : root, left, right
    //Postorder : left, right, root
    public static void inorder( TreeNode node, List<Integer> list ){
        if( node == null ) return;

        inorder( node.left, list);
        list.add(node.val);
        inorder( node.right, list );
    }



}
