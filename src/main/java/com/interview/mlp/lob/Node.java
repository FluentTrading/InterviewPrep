package com.interview.mlp.lob;

import java.util.HashMap;
import java.util.Map;

class Node implements Comparable<Node>{
    double price;
    int quantity;
    Map<Integer, Integer> orderId2Size;

    public Node( double price, int quantity ){
        this.price = price;
        this.quantity = quantity;
        this.orderId2Size = new HashMap<>();
    }

    public void insert(int orderId, int orderSize) {
        this.orderId2Size.put(orderId, orderSize);
    }

    public int deleteOrder(int orderId) {
        if(!orderId2Size. containsKey(orderId)) {
            throw new RuntimeException("order ID is not in this node.");
        }
        int oldSize = orderId2Size. get(orderId);
        orderId2Size. remove(orderId);
        this.quantity -= oldSize;
        return orderId2Size. size();
    }

    @Override
    public int compareTo(Node o) {
        return Double. compare(this. price, o. price);
    }
}