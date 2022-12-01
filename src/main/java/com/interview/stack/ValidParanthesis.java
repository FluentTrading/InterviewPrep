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
                //False is there is nothing to match
                if( stack.isEmpty() ){
                    return false;
                }else{
                    //Take out the potential closing bracket from the stack and match
                    if( stack.pop() != c ){
                        return false;
                    }
                }
            }
        }

        //Everything should be matched
        return stack.isEmpty();

    }

}
