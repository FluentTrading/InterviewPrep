package com.interview.mlp.lob;

//https://www.1point3acres.com/bbs/thread-668645-1-1.html

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class OrderBook {

    private PriorityQueue<Node> buyPQ;
    private PriorityQueue<Node> sellPQ;
    private Map<Integer, Node> orderId2Node;
    private Map<Double, Node> price2NodeBuy;
    private Map<Double, Node> price2NodeSell;

    public OrderBook(){
        this.buyPQ = new PriorityQueue<>(Collections.reverseOrder());
        this.sellPQ = new PriorityQueue<>();

        this.orderId2Node = new HashMap<>();
        this.price2NodeBuy = new HashMap<>();
        this.price2NodeSell = new HashMap<>();
    }


    // newOrder( int orderId, char side, int size, double price )
    // changeOrder( int orderId, int newSize )
    // replaceOrder( int oldOrderId, int orderId, char side, int size, double price )
    // deleteOrder( int orderId )
    // getNumLevels( char side ) - level for a side
    // double getLevelPrice( char side, int level )

    // adds order to order book
    public void newOrder( int orderId, char side, int size, double price ){

        switch( side ){

            case 'b':
                Node buynode = null;
                if( price2NodeBuy.containsKey(price) ){
                    buynode = price2NodeBuy.get(price);
                    buynode.insert(orderId, size);
                    orderId2Node.put(orderId, buynode);
                    buynode.quantity += size;

                }else{
                    buynode = new Node(price, size);
                    buynode.insert(orderId, size);
                    buyPQ.add(buynode);
                    orderId2Node.put(orderId, buynode);
                    price2NodeBuy. put(price, buynode);
                }
                break;
            case 's':
                Node sellnode = null;
                if(price2NodeSell. containsKey(price)) {
                    sellnode = price2NodeSell.get(price);
                    sellnode.insert(orderId, size);
                    orderId2Node.put(orderId, sellnode);
                    sellnode.quantity += size;
                } else {
                    sellnode = new Node(price, size);
                    sellnode.insert(orderId, size);
                    sellPQ.add(sellnode);
                    orderId2Node.put(orderId, sellnode);
                    price2NodeSell.put(price, sellnode);
                }
                break;
            default:
                throw new RuntimeException("Invalid side");
        }

    }


    // changes quantity contained in order
    public void changeOrder( int orderId, int newSize ){
        Node node = orderId2Node.get(orderId);
        if( node == null ) return;

        int oldSize = node.orderId2Size.get(orderId);
        node.orderId2Size.put(orderId, newSize);
        node.quantity += (newSize - oldSize);
    }


    // replaces order with different order
    public void replaceOrder( int oldOrderId, int orderId, char side, int size, double price ){
        deleteOrder(oldOrderId);
        newOrder(orderId, side, size, price);
    }


    // deletes order from orderbook
    public void deleteOrder( int orderId ){
        Node nodeToDelete = orderId2Node.get(orderId);
        PriorityQueue<Node> pq = null;
        boolean isBuy = true;
        if(buyPQ. contains(nodeToDelete)) {
            // order in buy side
            pq = buyPQ;
        } else if(sellPQ. contains(nodeToDelete)) {
            // order in sell side
            isBuy = false;
            pq = sellPQ;
        } else {
            return;
        }
        orderId2Node. remove(orderId);
        int leftSize = nodeToDelete.deleteOrder(orderId);
        if(leftSize == 0) {
            pq. remove(nodeToDelete);
            double price = nodeToDelete. price;
            if(isBuy) {
                price2NodeBuy. remove(price);
            } else {
                price2NodeSell. remove(price);
            }
        }
    }


    // returns the number of levels on a side
    public int getNumLevels( char side ){

        switch( side ){
            case 'b':
                return buyPQ.size();
            case 's':
                return sellPQ.size();
            default:
                throw new RuntimeException("Invalid side");
        }

    }


    // returns the price of a level. Level 0 is top of book.
    public double getLevelPrice( char side, int level ){
        Node node = getNodeByLevel(side, level);
        if(node == null) {
            return 0.0;
        }

        return node.price;
    }


    // returns the size of a level.
    public int getLevelSize( char side, int level ){
        Node node = getNodeByLevel(side, level);
        if( node == null ){
            return 0;
        }

        return node.quantity;
    }


    // returns the number of orders contained in price level.
    public int getLevelOrderCount(char side, int level) {
        Node node = getNodeByLevel(side, level);
        if( node == null ){
            return 0;
        }

        return node.orderId2Size.size();
    }


    private Node getNodeByLevel(char side, int level) {
        Node node = null;

        switch(side) {

            case 'b':
                PriorityQueue<Node> tmp1 = new PriorityQueue<>();
                while(level > 0){
                    tmp1.offer(buyPQ.poll());
                    level -= 1;
                }
                if(buyPQ. size() > 0) {
                    node = buyPQ.peek();
                    while(tmp1. size() > 0) {
                        buyPQ.offer(tmp1.poll());
                    }
                }
                break;
            case 's':
                PriorityQueue<Node> tmp2 = new PriorityQueue<>();
                while(level > 0){
                    tmp2.offer(sellPQ.poll());
                    level -= 1;
                }
                if(sellPQ. size() > 0) {
                    node = sellPQ.peek();
                    while(tmp2. size() > 0) {
                        sellPQ.offer(tmp2.poll());
                    }
                }
                break;
            default:
                throw new RuntimeException("Invalid side");
        }

        return node;

    }


    public static void main( String[] args ) throws IOException{

        OrderBook book = new OrderBook();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for( ;; ){

            String line = reader. readLine();
            if( line == null ) {
                break;
            }

            String[] tokens = line.split("\\s+");

            char instruction = tokens[0].charAt(0);
            char side = tokens[1].charAt(0);
            int orderId = 2 < tokens.length ? Integer.parseInt(tokens[2]) : -1;
            int size = 3 < tokens. length ? Integer. parseInt(tokens[3]) : -1;
            double price = 4 < tokens. length ? Double. parseDouble(tokens[4]) : Double. NaN;
            int oldOrderId = 5 < tokens. length ? Integer. parseInt(tokens[5]) : -1;

            switch (instruction) {
                case 'n':
                    book.newOrder(orderId, side, size, price);
                    break;

                case 'u':
                    book. changeOrder(orderId, size);
                    break;

                case 'r':
                    book.replaceOrder(oldOrderId, orderId, side, size, price);
                    break;

                case 'd':
                    book.deleteOrder(orderId);
                    break;

                case 'p':
                    System.out.println(String.format("%.2f", book.getLevelPrice(side, orderId)));
                    writer.write(String.format("%.2f", book.getLevelPrice(side, orderId)));
                    writer. newLine();
                    break;

                case 's':
                    System.out.println(String.format("%d", book.getLevelSize(side, orderId)));
                    writer.write(String.format("%d", book.getLevelSize(side, orderId)));
                    writer.newLine();
                    break;

                case 'l':
                    System.out.println(String.format("%d", book.getNumLevels(side)));
                    writer.write(String.format("%d", book.getNumLevels(side)));
                    writer.newLine();
                    break;

                case 'c':
                    System.out.println(String.format("%d", book.getLevelOrderCount(side, orderId)));
                    writer.write(String.format("%d", book.getLevelOrderCount(side, orderId)));
                    writer. newLine();
                    break;

                default:
                    writer.write("invalid input");
                    writer. newLine();

            }

        }

        writer. close();
        reader. close();
    }

}
