package com.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class KClosestPointToOrigin{

    private class PointDistance{
        int xpoint;
        int ypoint;
        int distance;

        PointDistance( int[] point ){
            this.xpoint = point[0];
            this.ypoint = point[1];
            this.distance = (int) Math.ceil(Math.sqrt( (xpoint*xpoint) + (ypoint*ypoint)));
            System.out.println("[" + xpoint + ", " + ypoint + "] Distance: " + distance);
        }

    }


    public List<int[]> kClosest( int[][] points, int k ){

        PriorityQueue<PointDistance> maxHeap = new PriorityQueue<>( (x, y) -> (y.distance - x.distance));

        for( int[] point : points ){
            PointDistance pd = new PointDistance( point );
            if( maxHeap.size() < k ){
                maxHeap.add( pd );
            }else{
                if( maxHeap.peek().distance > pd.distance ){
                    maxHeap.remove();
                    maxHeap.add( pd );
                }
            }
        }


        List<int[]> result = new ArrayList<>();
        while( !maxHeap.isEmpty() ){
            PointDistance p = maxHeap.poll();
            result.add( new int[]{p.xpoint, p.ypoint} );
        }

        return result;
    }


    public static void main(String[] args) {
        KClosestPointToOrigin closest = new KClosestPointToOrigin();
        List<int[]> result = closest.kClosest( new int[][]{ {3,3}, {5,-1}, {-2,4}}, 2);

        result.forEach( x -> System.out.println( Arrays.toString(x )) );

    }


}
