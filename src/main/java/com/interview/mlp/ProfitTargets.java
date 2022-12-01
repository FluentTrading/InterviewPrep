package com.interview.mlp;

import java.util.*;


public class ProfitTargets {

    public static int stockPairs( int[] stocksProfit, int target ){

        Set<Integer> priceSet = new HashSet<>();
        Arrays.stream(stocksProfit).forEach( x -> priceSet.add(x));

        Set<List<Integer>> result = new HashSet<>();

        for( int price : stocksProfit ){
            int compliment = (target - price);

            if( priceSet.contains(compliment) ){
                //So prices are ordered and Set can remove duplicated
                int first = Math.min(price, compliment);
                int second= Math.max(price, compliment);
                result.add( List.of(first, second) );
            }
        }

        System.out.println( result );
        return result.size();
    }


    public static void main(String[] args) {
        System.out.println( stockPairs( new int[]{5,7,9,13,11,6,6,3,3}, 12) );
    }


}
