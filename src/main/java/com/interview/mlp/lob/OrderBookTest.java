package com.interview.mlp.lob;

import java.util.List;

public class OrderBookTest {


    public static void main( String[] args ){

        String symbol = "AAPL";
        OrderBookManager manager= new OrderBookManager();
        Order buy1  = new Order(1, symbol, Side.BUY,  OrderAction.NEW_ORDER, 100.0, 5);
        manager.processOrder( buy1 );
        System.out.println( manager.getOrderBook(symbol) );


        Order sell1 = new Order(2, symbol, Side.SELL, OrderAction.NEW_ORDER, 100.0, 5);
        List<ExecutionReport> r2 = manager.processOrder( sell1 );
        System.out.println( r2 );

    }



}
