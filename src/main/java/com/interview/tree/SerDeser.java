package com.interview.tree;

import com.interview.util.TreeNode;

import java.util.*;

public class SerDeser {

    private static String NULL_STRING = "_N_";
    private static String DELIMITER = ",";
    public String serialize( TreeNode root ){
        return doSerialize( root, new StringBuilder() ).toString();
    }

    private StringBuilder doSerialize( TreeNode root, StringBuilder builder ){
        if( root == null )  return builder.append(NULL_STRING);

        builder.append(root.val).append(DELIMITER);
        doSerialize(root.left, builder).append(DELIMITER);
        doSerialize(root.right, builder);

        return builder;
    }


    public TreeNode deserialize( String data ){
        String[] dataArr = data.split(DELIMITER);
        Deque<String> list = new ArrayDeque<>();
        Arrays.stream(dataArr).forEach( x -> list.add(x));

        return doDeserialialization(list);
    }

    private TreeNode doDeserialialization( Deque<String> queue ){
        String value = queue.poll();
        if( NULL_STRING.equals(value) ) return null;

        TreeNode root   = new TreeNode(Integer.valueOf(value));
        root.left       = doDeserialialization(queue);
        root.right      = doDeserialialization(queue);

        return root;
    }


}
