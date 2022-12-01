package com.interview.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPriceFluctuation<T>{

    //https://leetcode.com/problems/stock-price-fluctuation/solutions/1905632/java-full-explanation-interview-tips-2-solutions/

    /*
    You are given a stream of records about a particular stock. Each record contains a timestamp and the corresponding price of the stock at that timestamp.
    Unfortunately due to the volatile nature of the stock market, the records do not come in order. Even worse, some records may be incorrect. Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.

    Design an algorithm that:

    Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
    Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
    Finds the maximum price the stock has been based on the current records.
    Finds the minimum price the stock has been based on the current records.
        */
    private int latestPrice;
    private int latestTimestmap;
    private final Map<Integer, Integer> time2PriceMap;
    private final TreeMap<Integer, Integer> priceCountMap;


    public StockPriceFluctuation( ){
        this.time2PriceMap = new HashMap<>();
        this.priceCountMap = new TreeMap<>();
    }


    public void update( int timestamp, int price ){

        updateTimestampPrice(timestamp, price);

        Integer prevPrice = time2PriceMap.get(timestamp);
        if( prevPrice != null ){ //This is a correction
            priceCountMap.put(prevPrice,  priceCountMap.get(prevPrice) - 1);
            if( priceCountMap.get(prevPrice) == 0 ){
                priceCountMap.remove(prevPrice);
            }
            System.out.println("Corrected: " +  timestamp + " -> " + price );

        }else{
            System.out.println("Added: " +  timestamp + " -> " + price );
        }

        time2PriceMap.put( timestamp, price );
        priceCountMap.put(price, priceCountMap.getOrDefault(price, 0) + 1);

    }

    private void updateTimestampPrice( int timestamp, int price ){
        if( timestamp >= latestTimestmap ){
            this.latestTimestmap = timestamp;
            this.latestPrice = price;
        }
    }


    public int current() {
        System.out.println("Curr: " +  latestPrice);
        return latestPrice;
    }


    public int maximum() {
        System.out.println("Max: " +  priceCountMap.lastKey() );
        return priceCountMap.lastKey();
    }


    public int minimum() {
        System.out.println("Min: " +  priceCountMap.firstKey() );
        return priceCountMap.firstKey();
    }



    public static void main(String[] args) {
        StockPriceFluctuation<Integer> stockPrice = new StockPriceFluctuation();
        stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
        stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
        stockPrice.current();     // return 5, the latest timestamp is 2 with the price being 5.
        stockPrice.maximum();     // return 10, the maximum price is 10 at timestamp 1.
        stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
        // Timestamps are [1,2] with corresponding prices [3,5].
        stockPrice.maximum();     // return 5, the maximum price is 5 after the correction.
        stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
        stockPrice.minimum();     // return 2, the minimum price is 2 at timestamp 4.

    }
}
