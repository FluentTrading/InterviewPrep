package com.interview.linkedlist;

import java.util.*;


public class CopyListRandomPointer {

    private static class Node{
        private int val;
        private Node next;
        private Node random;
        public Node( int val ){
            this.val = val;
        }
    }


    public static Node copyRandomList( Node head ){

        if( head == null ) return null;

        Map<Node, Node> copyMap = createCloneMap( head );

        Node curr = head;

        while( curr != null ){
            Node clone = copyMap.get( curr );
            clone.next = copyMap.get(curr.next);
            clone.random = copyMap.get(curr.random);

            curr = curr.next;
        }

        return copyMap.get(head);
    }

   private static Map<Node, Node> createCloneMap(Node head ){

        Node dummyHead = head;
        Map<Node, Node> map = new HashMap<>();

        while( dummyHead != null ){
            map.put( dummyHead, new Node(dummyHead.val) );
            dummyHead = dummyHead.next;
        }

        return map;

    }



}
