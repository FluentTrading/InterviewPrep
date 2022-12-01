package com.interview.linkedlist;

import com.interview.util.ListNode;

public class RemoveNode {

    //Remove all nodes whose value equals value
    public static ListNode removeElements( ListNode head, int value ){

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while( head != null ){
            if( head.getValue() != value ){
                dummy.setNext( new ListNode(head.getValue()) );
                dummy = dummy.getNext();
            }

            head = head.getNext();
        }

        return temp.getNext();

    }


}
