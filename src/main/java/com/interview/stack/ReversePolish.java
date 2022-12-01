package com.interview.stack;

import java.util.*;

public class ReversePolish {

    //Input: ["2","1","+","3","*"]
    //Output: 9
    //Explanation: ((2 + 1) * 3) = 9

    public int evalRPN( String[] tokens ){

        //Keep adding numbers to a stack till you find an operand
        //Then pop two numbers( first, second)
        //Compute the result with (first, second) and the operand
        //Push the result in the stack

        Set<String> operands = Set.of("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();

        for( String token : tokens ){

            //Handle operand
            if( operands.contains(token) ){
                int second  = stack.pop();
                int first = stack.pop();
                int result = 1;

                if( token.equals("+")){
                    result = first + second;

                }else if( token.equals("-")){
                    result = first - second;

                }else if( token.equals("*")){
                    result = first * second;

                }else{
                    result = (int) Math.floor(first/second);
                }

                stack.add( Integer.valueOf(result) );

            }else{
                stack.add( Integer.valueOf(token));
            }
        }

        return stack.peek();

    }


    public static void main(String[] args) {
        ReversePolish rp = new ReversePolish();
        System.out.println( rp.evalRPN( new String[] {"4","13","5","/","+"}) );
    }
}
