package com.interview.mlp.lob;

import java.util.*;

public class POrderBook {

    private final String symbol;
    private final TreeMap<Double, List<Order>> buyMap;
    private final TreeMap<Double, List<Order>> sellMap;

    private final static char PIPE = '|';
    private final static char NEWLINE = '\n';
    private final static int DEFAULT_ORDER_SIZE_PER_PRICE = 50;


    public POrderBook( String symbol ){
        this.symbol 	= symbol;
        this.sellMap 	= new TreeMap<>();
        this.buyMap 	= new TreeMap<>(Collections.reverseOrder());
    }


    public final String getSymbol(){
        return symbol;
    }


    protected final TreeMap<Double, List<Order>> getBuyMap(){
        return buyMap;
    }

    protected final void addToBuyMap( Order order ){
        List<Order> buys = buyMap.getOrDefault(order.getPrice(), new ArrayList<>(DEFAULT_ORDER_SIZE_PER_PRICE));
        buys.add(order);
        buyMap.put(order.getPrice(), buys);

        //buyMap.computeIfAbsent(order.getPrice(), k -> new ArrayList<>(DEFAULT_ORDER_SIZE_PER_PRICE)).add(order);
    }


    protected final TreeMap<Double, List<Order>> getSellMap(){
        return sellMap;
    }


    protected final void addToSellMap( Order order ){
        sellMap.computeIfAbsent(order.getPrice(), k -> new ArrayList<>(DEFAULT_ORDER_SIZE_PER_PRICE)).add(order);
    }


    public final String toBuyString(){
        return toString( buyMap );
    }

    public final String toSellString(){
        return toString( sellMap );
    }

    private final String toString( Map<Double, List<Order>> orderMap ){
        StringBuilder builder = new StringBuilder();

        for( List<Order> orders : orderMap.values() ){
            for( Order order : orders ) {
                builder.append(order.toString()).append(PIPE);
            }
            builder.append(NEWLINE);
        }

        return builder.toString();
    }


    @Override
    public final String toString(){

        StringBuilder builder = new StringBuilder();
        builder.append( "Buys:" ).append(NEWLINE).append( toBuyString() )
                .append( NEWLINE ).append( "Sells:" ).append(NEWLINE).append( toSellString() );

        return builder.toString();
    }



}
