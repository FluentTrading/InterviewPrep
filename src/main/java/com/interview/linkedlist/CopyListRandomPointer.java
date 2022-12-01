package com.interview.linkedlist;

import java.util.*;


public class CopyListRandomPointer {

    private static class RandomNode {
        private int val;
        private RandomNode next;
        private RandomNode random;
        public RandomNode(int val ){
            this.val = val;
        }
    }


    public static RandomNode copyRandomList( RandomNode head ){
        if( head == null ) return null;

        Map<RandomNode, RandomNode> copyMap = createCopyMap( head );

        RandomNode curr = head;

        while( curr != null ){
            RandomNode clone = copyMap.get( curr );
            clone.next = copyMap.get(curr.next);
            clone.random = copyMap.get(curr.random);

            curr = curr.next;
        }

        return copyMap.get(head);

    }

   private static Map<RandomNode, RandomNode> createCopyMap( RandomNode head ){

        RandomNode tmp = head;
        Map<RandomNode, RandomNode> map = new HashMap<>();

        while( tmp != null ){
            map.put( tmp, new RandomNode(tmp.val) );
            tmp = tmp.next;
        }

        return map;

    }



}
