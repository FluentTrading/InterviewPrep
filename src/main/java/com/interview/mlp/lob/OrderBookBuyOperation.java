package com.interview.mlp.lob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OrderBookBuyOperation {

    /**
     * Bid				Ask
     *
     * 99.0 - 4500		101.0 - 2000
     * 98.0	- 3400		102.0 - 5000
     * 97.0	- 2500		103.0 - 7000
     */

    public static final List<ExecutionReport> processBuy( Order buyOrder, POrderBook book ){
        boolean isBuyLessThanBestAsk= isBuyLessThanBestAsk( buyOrder, book );
        if( isBuyLessThanBestAsk ){
            return handleBuyLessThanBestAsk( buyOrder, book);

        }else {
            //There are 1 or more matches
            return handleSellSweep(buyOrder, book);
        }
    }


    //Buying price is less than best ask price, no match. Order gets added to buy map.
    public static final boolean isBuyLessThanBestAsk( Order buyOrder, POrderBook book ){
        if( book.getSellMap().isEmpty() ){
            return true;
        }

        return ( buyOrder.getPrice() < book.getSellMap().firstKey() );

    }


    //Buying price is less than best ask price, no match. Order gets added to buy map.
    public static final List<ExecutionReport> handleBuyLessThanBestAsk( Order buyOrder, POrderBook book ){
        addOrderToBuyMap( buyOrder, book );
        return Collections.emptyList();
    }


    public static final List<ExecutionReport> handleSellSweep( Order order, POrderBook book ){

        int totalFilled     = 0;
        int orderQuantity   = order.getQuantity();
        List<ExecutionReport> result = new ArrayList<>();

        while( totalFilled < orderQuantity ){

            for( List<Order> sellOrders : book.getSellMap().values() ){
                for( Order sellOrder : sellOrders ){
                    int qtyFilled   = Math.min(orderQuantity, sellOrder.getQuantity());
                    totalFilled     = totalFilled + qtyFilled;
                    ExecutionReport report= ExecutionReport.of(order.getSymbol(), Side.BUY, sellOrder.getPrice(), qtyFilled, order.getOrderId(), sellOrder.getOrderId());
                    result.add(report);
                    System.out.println(report);

                    if( totalFilled == orderQuantity ){
                        System.out.println(order.getOrderId() + " filled " + totalFilled + " of order quantity " + orderQuantity );
                        break;
                    }
                }
            }

            //If we came here, we exhausted all the SellOrders but still didn't fully fill the order.
            //Remaining qty needs to be posted.
            addResidualOrderBuyMap( order, totalFilled, book );
            System.out.println(order.getOrderId() + " sweep done but only " + totalFilled + "/" + orderQuantity + " was filled.");
            break;

        }

        return result;

    }


    public static final void addResidualOrderBuyMap( Order buyOrder, int filledQuantity, POrderBook book ){
        int residualQuantity= (buyOrder.getQuantity() - filledQuantity);
        Order residualOrder = new Order( residualQuantity, buyOrder);
        book.addToBuyMap( residualOrder );
    }


    public static final void addOrderToBuyMap( Order buyOrder, POrderBook book ){
        book.addToBuyMap( buyOrder );
    }


}
