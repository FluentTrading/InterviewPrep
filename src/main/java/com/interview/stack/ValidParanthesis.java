package com.interview.stack;

import java.util.Stack;

public class ValidParanthesis {

    public boolean isValid( String s ){

        Stack<Character> stack = new Stack<>();

        for( char c : s.toCharArray() ){

            //For open brackets, we push its corresponding closing bracket
            if( c == '(' ){
                stack.push( ')');

            }else if( c == '{'){
                stack.push( '}');

            }else if( c == '['){
                stack.push( ']');

            }else{
                if( stack.isEmpty() ){
                    return false;
                }else{
                    //This must be a closing bracket and it must match the closing bracket from the stack
                    if( c != stack.pop() ){
                        return false;
                    }
                }
            }
        }

        //Everything should be matched
        return stack.isEmpty();

    }

}
