package com.interview.stack;

public class MinStack {

    //Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    private StackNode head;

    public void push( int value ){
        if( head == null ){
            this.head = new StackNode(value, value, null);
        }else{
            StackNode prev = head;
            this.head = new StackNode(value, Math.min(value, head.min), prev);
        }
    }


    public void pop(){
        this.head = head.next;
    }


    public int top(){
        return head.val;
    }


    public int getMin(){
        return head.min;
    }

    private class StackNode {
        int val;
        int min;
        StackNode next;

        private StackNode( int val, int min, StackNode next ){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }


}
