package com.interview.dp;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/coin-change-2/submissions/
public class CoinChangeII {

    public static int coinChange(int amount, int[] coins) {
        return doCoinChange( 0, amount, coins, new HashMap<>() );
    }

    private static int doCoinChange( int index, int amount, int[] coins, Map<String, Integer> dp){

        if( amount == 0 ){
            return 1;
        }

        if( amount < 0 ){
            return 0;
        }

        if( index >= coins.length ){
            return 0;
        }

        String key = amount + "|" + index;

        if( dp.containsKey(key) ){
            return dp.get(key);
        }else{

            if( coins[index] > amount ){
                dp.put( key, doCoinChange(index+1, amount, coins, dp));
            }else{
                int unselected = doCoinChange(index+1, amount, coins, dp);
                int selected = doCoinChange(index, amount-coins[index], coins, dp);
                dp.put( key, (unselected + selected));
            }
        }

        return dp.get(key);
    }

    public static void main( String[] args ){
        System.out.println( coinChange( 5, new int[]{1, 2, 5} ) );
    }

}
