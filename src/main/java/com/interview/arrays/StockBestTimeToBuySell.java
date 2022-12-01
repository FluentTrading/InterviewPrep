package com.interview.arrays;

import java.util.Arrays;

public class StockBestTimeToBuySell {


    //Buy and sell on different days in the future.
    public int maxProfit1( int[] prices ){
        int currProfit = 0;
        int maxProfit  = 0;

        for( int i=1; i<prices.length; i++ ){
            //Either there is a profit (sell > buy) OR there is a loss (so we don't do a trade and take a profit of 0)
            currProfit = Math.max( 0, currProfit + (prices[i] - prices[i-1]) );
            maxProfit = Math.max(currProfit, maxProfit);
        }

        return maxProfit;
    }


    //Can buy and immediately sell it on the same day.
    //We greedily keep adding profits at every interval
    public int maxProfit2( int[] prices ){
        int currProfit = 0;
        for( int i=1; i<prices.length; i++ ){
            currProfit += Math.max( 0,  (prices[i] - prices[i-1]) );
        }

        return currProfit;
    }


    //Can buy/sell multiple times but
    //1. After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
    //2. You must sell the stock before you buy again

    public int maxProfitWithCooldown( int[] prices ){

        int[] buy       = new int[prices.length]; //buy[i] means max profit by buying till ith day
        int[] sell      = new int[prices.length];
        int[] cooldown  = new int[prices.length];

        //no choice on day 0
        buy[0]          = -prices[0];

        for( int i=1; i<prices.length; i++){
            //If we buy today, yesterday must be cooldown as we cannot buy right after sell.
            //Max of “the max buy profit till yesterday" vs “cooldown yesterday and buy today”
            buy[i]      = Math.max( buy[i-1], cooldown[i-1] - prices[i] );

            //If we sell today, yesterday must be buy. Max of profit buy selling yesterday vs taking profit today and adding to
            sell[i]     = Math.max( sell[i-1], prices[i]+buy[i-1] );
            cooldown[i] = Math.max( cooldown[i-1], sell[i-1] );
        }

        return Math.max(sell[prices.length-1], cooldown[prices.length-1]);

    }


    /**
     * We know, in advance, prices of a stock for the next 3 days is [1, 2, 100]
     * Write a method to return the max profit you can achieve. [ Buy at 1, Sell at 100 AND Buy at 2, Sell at 100] = Total Profit = 197
     *
     * Step 1. Find max price and its index, this will be our selling price
     * Step 2: Treat every price at index less than maxIndex as buyPrice and compute profit += MaxPrice - buyPrice
     * Step 3:
     * a) If maxPriceIndex was the last index in the array, we are done, return profit
     * b) If there are other prices after the maxIndx (1, 2, 100, 40, 60), redo Step 1-3 for the price array {40, 50}
     */

    public static int stockMax( int[] prices ){
        return getStockMax( 0, prices );
    }
    public static int getStockMax( int profit, int[] prices ){
        if( prices.length < 2 ) return profit;

        //Step 1: Get Selling price
        int maxPrice = Integer.MIN_VALUE;
        int maxPriceIndx = -1;
        for ( int i=0; i<prices.length; i++ ){
            if( prices[i] > maxPrice ){
                maxPrice = prices[i];
                maxPriceIndx = i;
            }
        }

        //Step 2. Compute profit using this selling price
        for ( int i=0; i<prices.length; i++ ){
            if( i < maxPriceIndx ){
                profit += (maxPrice - prices[i]);
            }
        }

        //Step 3:
        if( maxPriceIndx == prices.length -1 ){
            return profit;
        }else{
            //Case B: [1, 4, 100, 60, 70] = We have profits for 1, 4, 100 BUT we also need to compute profit for 60, 70
            return getStockMax(profit, Arrays.copyOfRange(prices, maxPriceIndx + 1, prices.length));
        }
    }


}
