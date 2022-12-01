package com.interview.dp;

import java.util.*;


public class CoinChangeI {


    //BFS
    //Subtract each of the coins from the total amount. Keep doing it till the amount become 0
    //Ignore when your diff goes below 0
    //Memoize using a visited set so that you don't re-calculate the branches of the graph that you've already seen once

    public int coinChange( int[] coins, int amount ){

        if( coins.length == 0 || amount < 1) return 0;

        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.addFirst(amount);
        visited.add(amount);

        int currLevel = 0;

        while( !queue.isEmpty() ){

            int size = queue.size();

            for( int i=0; i<size; i++ ){
                int currAmount = queue.removeLast();
                if( currAmount == 0 ) return currLevel;
                if( currAmount < 0 ) continue;

                for( int coin : coins ){
                    int remainingAmount = (currAmount - coin);
                    if( remainingAmount >= 0 && !visited.contains(remainingAmount) ){
                        queue.addFirst(remainingAmount);
                        visited.add(remainingAmount);
                    }
                }
            }

            currLevel++;
        }

        return -1;
    }


}
