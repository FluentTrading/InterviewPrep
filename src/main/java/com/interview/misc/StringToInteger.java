package com.interview.misc;

public class StringToInteger {

    public int myAtoi( String str ){

        if( str == null ) return 0;
        str = str.trim();
        if( str.isEmpty() ) return 0;

        int sign = 1;
        int index = 0;
        int result = 0;

        //Check the first index, do we have a negative number
        if( str.charAt(index) == '-' ){
            index++;
            sign = -1;
        }else if( str.charAt(index) == '+' ){
            index++;
        }

        while( index < str.length() ){
            char charValue = str.charAt(index);
            if( !Character.isDigit(charValue) ){
                break;
            }

            int charIntValue = Character.getNumericValue(charValue);
            boolean overflow= false;
            try{
                Math.multiplyExact(result, 10);
                Math.addExact( (result*10), charIntValue);
            }catch ( ArithmeticException e ){
                overflow = true;
            }

            if( overflow ){
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + charIntValue;
            index++;
        }

        return result * sign;

    }

}
