package com.interview.tree;

public class BinaryTreeFromPreorderAndInorderTraversal {

    public class MyTreeNode {
      int val;
        MyTreeNode left;
        MyTreeNode right;
        MyTreeNode() {}
        MyTreeNode(int val) { this.val = val; }
        MyTreeNode(int val, MyTreeNode left, MyTreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    private int in = 0;
    private int pre = 0;

    public MyTreeNode buildTree( int[] preorder, int[] inorder ){
        return build( preorder, inorder, Integer.MIN_VALUE );
    }

    private MyTreeNode build( int[] preorder, int[] inorder, int stop ){
        if( pre >= preorder.length ){
            return null;
        }

        if( inorder[in] == stop ){
            in++;
            return null;
        }

        MyTreeNode node = new MyTreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);

        return node;

    }


}
