package com.interview.linkedlist;

import com.interview.util.ListNode;

public class RemoveNthNodeFromEnd {

    //Remove nth node from the end
    public ListNode removeNthFromEnd( ListNode head, int n ){

        int count = 0;

        int nFromFront  = LinkedList.getSize(head) - n +1;
        ListNode curr   = new ListNode(-1);
        ListNode result = curr;

        while( head != null ){
            ++count;

            //Copy the nodes needed
            if( count != nFromFront ){
                curr.setNext( new ListNode( head.getValue()) );
                curr = curr.getNext();
            }

            head = head.getNext();
        }

        return result.getNext();

    }

}
