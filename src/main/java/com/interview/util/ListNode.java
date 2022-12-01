package com.interview.util;

public class ListNode{
    private int val;
    private ListNode next;

    public ListNode( ){ }
    public ListNode( int val ){
        this.val = val;
    }

    public ListNode( int val, ListNode next ){
        this.val = val; this.next = next;
    }

    public int getValue(){
        return val;
    }

    public void setValue(int value) {
        this.val = val;
    }
    public ListNode getNext(){
        return next;
    }
    public void setNext( ListNode next ){
        this.next = next;
    }


    public static void printLinkedList( ListNode node ){
        StringBuilder builder = new StringBuilder();

        ListNode head = node;
        while( head != null ){
            builder.append( head.getValue() ).append(" ");
            head = head.getNext();
        }

        System.out.println( builder );

    }
}