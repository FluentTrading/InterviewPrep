package com.interview.linkedlist;

import util.ListNode;

public class LinkedList {

    //head      next
    //1     ->  2       -> 3    -> 4
    //a. Create a previous node
    //b. Set head.next to previous (but this breaks the link from 1 -> 2).
    //c. Store head.next in a variable (next) and then set head.next to previous
    //d. prev = head
    //e. head = next to move the chain
    //f. Return previous (as head at the end point to the end of the chain. Prev will point to the first element)
    public ListNode reverseList( ListNode head ){
        ListNode prev = null;

        while( head != null ){
            ListNode next = head.getNext();

            head.setNext(prev);
            prev = head;
            head = next;    //Move the chain
        }

        return prev;
    }


    //Floyd's tortoise and hare algorithm
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while( slow != null && fast != null && fast.getNext() != null ){
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if( slow.equals(fast) ){
                return true;
            }
        }

        return false;
    }


    public static int getSize( ListNode head ){
        int size = 0;
        ListNode tmp = head;

        while( tmp != null ){
            ++size;
            tmp = tmp.getNext();
        }

        return size;
    }


}
