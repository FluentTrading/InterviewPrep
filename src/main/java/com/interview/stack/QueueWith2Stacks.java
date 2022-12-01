package com.interview.stack;

import java.util.Stack;

public class QueueWith2Stacks<T>{

    private enum State{
        ADDING,
        GETTING,
        UNKNOWN;
    }
    private Stack<T> stack1;
    private Stack<T> stack2;

    private State state = State.UNKNOWN;

    public QueueWith2Stacks( ){
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(T element ){
        if( state == State.UNKNOWN ){
            stack1.add(element);
            state = State.ADDING;

        }else if( state == State.ADDING ){
            stack1.add( element );

        }else{
            //We had moved elements to stack2, put all of them back and then add this element
            while( !stack2.isEmpty() ){
                stack1.add( stack2.pop() );
            }

            stack1.add( element );
            state = State.ADDING;
        }
    }


    public T pop(  ){
        if( state == State.UNKNOWN ){
            throw new IllegalStateException("Nothing to get");

        }else if( state == State.GETTING ){
            return stack2.pop();

        }else{
            //We had moved elements to stack2, put all of them back and then add this element
            while( !stack1.isEmpty() ){
                stack2.add( stack1.pop() );
            }

            state = State.GETTING;
            return stack2.pop();
        }
    }

}
