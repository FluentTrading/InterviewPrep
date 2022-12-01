package com.interview.stack;

import java.util.Stack;

public class BasicCalculator {

    //Given a string s representing a valid expression, implement a basic calculator to evaluate it.
    public int calculate( String expression ){
        System.out.println(expression);
        int result = 0;
        int sign = 1;
        int number = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(sign);

        for( int i = 0; i < expression.length(); i++ ){
            char currentChar = expression.charAt(i);

            if( Character.isDigit(currentChar) ){
                System.out.println("Number= 10*" + (number) + (int)(currentChar));
                number = (10 * number) + Character.getNumericValue(currentChar);


            }else if( currentChar == '+'  ){
                System.out.println("+ result= " + (result) + (sign) +"*"+number);
                result += sign * number;
                sign = stack.peek() * 1;
                number = 0;


            }else if( currentChar == '-' ){
                System.out.println("- result= " + (result) + (sign) +"*"+number);
                result += sign * number;
                sign = stack.peek() * -1;
                number = 0;

            } else if(currentChar == '(' ){
                System.out.println("( =  Adding to stack: " + sign);
                stack.push(sign);

            } else if(currentChar == ')') {
                int e = stack.pop();
                System.out.println(") Popped from stack: " + e);
            }
        }

        result += sign * number;
        return result;

    }


    public static void main(String[] args) {
        BasicCalculator c = new BasicCalculator();
        System.out.println( c.calculate( "9+(5-3)") );
    }
}
