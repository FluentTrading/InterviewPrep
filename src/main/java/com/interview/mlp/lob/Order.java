package com.interview.mlp.lob;


public class Order {
    private final long orderId;
    private final String symbol;

    private final Side side;
    private final OrderAction action;
    private final double price;
    private final int quantity;

    private final static char COMMA = ',';
    private final static char X = 'x';


    public Order( int residualQuantity, Order originalOrder ){
        this( originalOrder.orderId, originalOrder.symbol, originalOrder.side, originalOrder.action, originalOrder.getPrice(), residualQuantity );
    }

    public Order( long orderId, String symbol, Side side, OrderAction action, double price, int quantity ){
        this.orderId    = orderId;
        this.symbol 	= symbol;
        this.side       = side;
        this.price 		= price;
        this.action     = action;
        this.quantity 	= quantity;
    }


    public final long getOrderId(){
        return orderId;
    }


    public final String getSymbol(){
        return symbol;
    }

    public final Side getSide(){
        return side;
    }

    public final OrderAction getAction(){
        return action;
    }

    public final double getPrice(){
        return price;
    }

    public final int getQuantity(){
        return quantity;
    }

    @Override
    public final String toString( ){
        StringBuilder builder = new StringBuilder();
        return builder.append(orderId).append(COMMA)
                .append(symbol).append(COMMA)
                .append(action.name()).append(COMMA)
                .append(side).append(COMMA)
                .append(quantity).append(X)
                .append(price)
                .toString();
    }

}

