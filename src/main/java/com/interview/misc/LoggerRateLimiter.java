package com.interview.misc;

import java.util.*;

public class LoggerRateLimiter {
    private final int timeInterval;
    private final Map<String, Integer> msgMap;

    public LoggerRateLimiter( int timeInterval ){
        this.timeInterval = timeInterval;
        this.msgMap = new HashMap<>();
    }

    public boolean shouldPrintMessage( int timestamp, String message ){

        Integer savedTime = msgMap.get(message);
        if( savedTime == null ){
            msgMap.put(message, timestamp);
            return true;

        }else{
            int diff = timestamp - savedTime;
            if( diff < timeInterval ){
                return false;
            }else{
                msgMap.put(message, timestamp);
                return true;
            }
        }
    }


    public static void main( String[] args ){
        LoggerRateLimiter logger = new LoggerRateLimiter(10);
        System.out.println( logger.shouldPrintMessage(1, "foo"));// return true,
        System.out.println( logger.shouldPrintMessage(2, "bar")); // return true,
        System.out.println(logger.shouldPrintMessage(3, "foo"));  // 3 < 11, return false
        System.out.println(logger.shouldPrintMessage(8, "bar"));  // 8 < 12, return false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // 10 < 11, return false
        System.out.println(logger.shouldPrintMessage(11, "foo")); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
    }

}
