package com.interview.mlp.lob;


import java.util.Arrays;
import java.util.StringJoiner;

public final class ExecutionReport{

    private final String symbol;
    private final Side side;
    private final double price;
    private final double quantity;

    private final long agressOrderId;
    private final long restingOrderId;

    public ExecutionReport( String symbol, Side side, double price, double quantity, long agressOrderId, long restingOrderId ){
        this.symbol   	= symbol;
        this.side       = side;
        this.price   	= price;
        this.quantity   = quantity;
        this.agressOrderId =agressOrderId;
        this.restingOrderId = restingOrderId;
    }


    public static ExecutionReport of( String symbol, Side side, double price, double quantity, long agressOrderId, long restingOrderId ){
        return new ExecutionReport( symbol, side, price, quantity, agressOrderId, restingOrderId );
    }


    public final String getSymbol(){
        return symbol;
    }

    public final Side getSide(){
        return side;
    }

    public final double getPrice(){
        return price;
    }

    public final double getQuantity() {
        return quantity;
    }

    public final long getAgressOrderId() {
        return agressOrderId;
    }

    public final long getRestingOrderId() {
        return restingOrderId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExecutionReport.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("side=" + side)
                .add("price=" + price)
                .add("quantity=" + quantity)
                .add("agressOrderId=" + agressOrderId)
                .add("restingOrderId=" + restingOrderId)
                .toString();
    }
}