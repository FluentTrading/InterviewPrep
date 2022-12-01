package com.interview.misc;

import java.util.Map;

public class RomanToInteger {

    public static int romanToInt( String romanNumeral ){

        Map<Character, Integer> romanToNumberMap = Map.of(
                'I',1,
                'V',5,
                'X',10,
                'L',50,
                'C',100,
                'D',500,
                'M',1000);

        char[] romanChars = romanNumeral.toCharArray();

        int lastValue = romanToNumberMap.get(romanChars[0]);
        int summation = lastValue;

        for( int i =1; i< romanChars.length; i++ ){

            int thisValue   = romanToNumberMap.get(romanChars[i]);
            if( lastValue >= thisValue ){
                summation += thisValue;
            }else {
                summation = (summation - lastValue) + (thisValue - lastValue);
            }

            lastValue = thisValue;

        }

        return summation;

    }

}
