package com.interview.mlp;

import java.util.*;

public class QueuedSeats {

    public Map<Integer, Integer> assignSeats( int[] seatIds ){
        int indx =1;
        Deque<int[]> desiredSeatIds = new ArrayDeque<>();
        for( int seatId : seatIds ){
            desiredSeatIds.add( new int[]{indx++, seatId});
        }

        return assignSeats( desiredSeatIds );
    }


    private Map<Integer, Integer> assignSeats( Deque<int[]> desiredSeatIds ){

        Map<Integer, Integer> result = new HashMap<>();

        while( !desiredSeatIds.isEmpty() ){

            int[] personSeat = desiredSeatIds.poll();
            int personId = personSeat[0];
            int seatId = personSeat[1];

            if( result.containsKey(seatId) ){
                desiredSeatIds.addLast(new int[]{personId, (seatId + 1)});
            }else{
                result.put(seatId, personId);
            }

        }

        return result;

    }


    public static void main(String[] args) {
        Map<Integer, Integer> result = new QueuedSeats().assignSeats( new int[]{1, 2, 3, 2, 4});

        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Integer, Integer> entry : result.entrySet() ){
            builder.append( "Seat ").append(entry.getKey() ).append( " is allocated to Person ").append(entry.getValue()).append("\n");
        }

        System.out.println( builder);
    }
}
