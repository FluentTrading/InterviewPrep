package com.interview.mlp.lob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OrderBookSellOperation {

    /**
     * Bid				Ask
     *
     * 99.0 - 4500		101.0 - 2000
     * 98.0	- 3400		102.0 - 5000
     * 97.0	- 2500		103.0 - 7000
     */

    public static final List<ExecutionReport> processSell( Order sellOrder, POrderBook book ){
        boolean isSellMoreThanBestBid= isSellMoreThanBestBid( sellOrder, book );
        if( isSellMoreThanBestBid ){
            return handleSellMoreThanBestBid( sellOrder, book);

        }else {
            //There are 1 or more matches
            return handleBuySweep(sellOrder, book);
        }
    }

    //Selling price is more than the best bid price
    public static final boolean isSellMoreThanBestBid( Order sellOrder, POrderBook book ) {
        if( book.getBuyMap().isEmpty() ){
            return true;
        }

        return (sellOrder.getPrice() > book.getBuyMap().firstKey());
    }

    //Selling price is more than the best bid price, no match. Order gets added to sell map.
    public static final List<ExecutionReport> handleSellMoreThanBestBid( Order sellOrder, POrderBook book ){
        addOrderToSellMap( sellOrder, book );
        return Collections.emptyList();
    }



    public static final List<ExecutionReport> handleBuySweep( Order sellOrder, POrderBook book ){

        int totalFilled     = 0;
        int orderQuantity   = sellOrder.getQuantity();
        List<ExecutionReport> result = new ArrayList<>();

        while( totalFilled < orderQuantity ){

            for( List<Order> buyOrders : book.getBuyMap().values() ){
                for( Order buyOrder : buyOrders ){
                    int qtyFilled   = Math.min(orderQuantity, buyOrder.getQuantity());
                    totalFilled     = totalFilled + qtyFilled;
                    ExecutionReport report= ExecutionReport.of(sellOrder.getSymbol(), Side.SELL, sellOrder.getPrice(), qtyFilled, sellOrder.getOrderId(), sellOrder.getOrderId());
                    result.add(report);
                    System.out.println(report);

                    if( totalFilled == orderQuantity ){
                        System.out.println(sellOrder.getOrderId() + " filled " + totalFilled + " of order quantity " + orderQuantity );
                        break;
                    }
                }
            }

            //If we came here, we exhausted all the SellOrders but still didn't fully fill the order.
            //Remaining qty needs to be posted.
            addResidualOrderSellMap( sellOrder, totalFilled, book );
            System.out.println("Buy sweep done for " + sellOrder.getOrderId() + " but only " + totalFilled + "/" + orderQuantity + " was filled.");
            break;

        }

        return result;

    }



    public static final void addResidualOrderSellMap( Order sellOrder, int filledQuantity, POrderBook book ){
        int residualQuantity= (sellOrder.getQuantity() - filledQuantity);
        Order residualOrder = new Order( residualQuantity, sellOrder);
        book.addToSellMap( residualOrder );
    }


    public static final void addOrderToSellMap( Order sellOrder, POrderBook book ){
        book.addToSellMap( sellOrder );
    }


}
