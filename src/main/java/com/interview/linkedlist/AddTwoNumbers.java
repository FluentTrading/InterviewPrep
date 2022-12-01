package com.interview.linkedlist;

import util.ListNode;

public class AddTwoNumbers {

    public static ListNode addNumbers(ListNode head1, ListNode head2 ){

        ListNode curr1 = head1;
        ListNode curr2 = head2;
        int carry = 0;

        ListNode result = new ListNode();
        ListNode temp   = result;

        while( curr1 != null || curr2 != null ){

            //Since Node can be of different length, we need to ensure that one of them is not null
            int val1    = (curr1 == null) ? 0 :  curr1.getValue();
            int val2    = (curr2 == null) ? 0 :  curr2.getValue();

            int sum     = carry + val1 + val2;
            int remainder= sum % 10;
            carry       = sum / 10;
            temp.setNext( new ListNode(remainder) );

            //Move the chains
            curr1 = curr1.getNext();
            curr2 = curr2.getNext();
            temp = temp.getNext();
        }

        //If Carry is non-zero, we need to add it
        if( carry > 0 ){
            temp.setNext( new ListNode(carry) );
        }

        return result.getNext();
    }



    public static void print( ListNode sum ){
        ListNode curr = sum;
        while( curr != null ){
            System.out.print(curr.getValue() + " ");
            curr = curr.getNext();
        }
    }


    public static void main( String[] args ){
        ListNode one = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode two = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode sum = addNumbers( one, two );
        print(sum);

    }

}
