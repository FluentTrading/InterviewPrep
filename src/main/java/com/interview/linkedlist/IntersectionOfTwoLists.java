package com.interview.linkedlist;

import com.interview.util.ListNode;

public class IntersectionOfTwoLists {



    public ListNode getIntersectionNode(ListNode headA, ListNode headB ){

        int aSize = LinkedList.getSize(headA);
        int bSize = LinkedList.getSize(headB);
        int diff  = Math.abs(aSize - bSize);

        //Align the two nodes
        if( aSize > bSize ){
            for( int i=0; i<diff; i++ ){
                headA = headA.getNext();
            }
        }else if( bSize > aSize ){
            for( int i=0; i<diff; i++ ){
                headB = headB.getNext();
            }
        }


        while( headA != null && headB != null ){
            if( headA.equals(headB) ){
                return headA;
            }

            headA = headA.getNext();
            headB = headB.getNext();
        }

        return null;
    }


}
