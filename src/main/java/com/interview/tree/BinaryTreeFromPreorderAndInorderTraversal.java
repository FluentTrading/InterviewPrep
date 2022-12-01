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


    private int inorderIndx = 0;
    private int preorderIndx = 0;

    //Inorder   : left, root, right
    //Preorder  : root, left, right
    //Postorder : left, right, root

    public MyTreeNode buildTree( int[] preorder, int[] inorder ){
        return build( preorder, inorder, Integer.MIN_VALUE );
    }

    private MyTreeNode build( int[] preorder, int[] inorder, int stop ){
        if( preorderIndx >= preorder.length ){
            return null;
        }

        if( inorder[inorderIndx] == stop ){
            inorderIndx++;
            return null;
        }

        MyTreeNode root = new MyTreeNode(preorder[preorderIndx++]);
        root.left = build(preorder, inorder, root.val);
        root.right = build(preorder, inorder, stop);

        return root;

    }


}
