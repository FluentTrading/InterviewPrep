package com.interview.mlp.lob;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderBookManager {

    private final Map<String, POrderBook> symbolOrderMap;

    public OrderBookManager( ){
        this.symbolOrderMap = new HashMap<>();
    }

    public POrderBook getOrderBook( String symbol ){
        return symbolOrderMap.getOrDefault(symbol, new POrderBook(symbol) );
    }


    public List<ExecutionReport> processOrder( Order order ){
        POrderBook book = getOrderBook( order.getSymbol() );


        switch ( order.getSide() ){
            case BUY:
                return OrderBookBuyOperation.processBuy(order, book);

            case SELL:
                return OrderBookSellOperation.processSell(order, book);

            default:
                throw new IllegalStateException("Unsupported side " + order );
        }

    }

}
