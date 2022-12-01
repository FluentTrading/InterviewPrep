package com.interview.linkedlist;

import com.interview.util.ListNode;

public class RemoveNode {

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


    //Remove all nodes whose value equals value
    public static ListNode removeElements( ListNode head, int value ){

        ListNode dummy = new ListNode(-1);

        //At the end of the loop, dummy will point to the end, so need to keep a reference that doesnt move to return.
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
