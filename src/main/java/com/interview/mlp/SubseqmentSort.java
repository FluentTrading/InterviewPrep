package com.interview.mlp;

import java.util.Arrays;

public class SubseqmentSort {


    /**
     *  Input:      1, 0, 2, 3, 4
     *  LeftMax:    1, 1, 2, 3, 4
     *  RightMin:   0, 0, 2, 3, 4
     *
     *  Where leftMax(i) <= rigthtMin(i+1) we can partition
     */

    public int subSegmentSort ( int[] input ){
        System.out.println("input: " + Arrays.toString(input));

        int length          = input.length;
        int[] maxOfLeft     = new int[length];
        int[] minOfRight    = new int[length];

        maxOfLeft[0]        = input[0];
        for( int i = 1; i < length; i++ ){
            //Max of input[i] or the previous number in maxLeft
            maxOfLeft[i] = Math.max( input[i], maxOfLeft[i-1] );
        }
        System.out.println("Left: " + Arrays.toString(maxOfLeft));

        minOfRight[length - 1] = input[length - 1];
        for( int i=length-2; i >= 0; i-- ){
            //Max of input[i] or the previous number in maxLeft
            minOfRight[i] = Math.min( input[i], minOfRight[i + 1] );
        }
        System.out.println("Right: " + Arrays.toString(minOfRight));

        int partitionCount = 0;
        for( int i = 0; i < length - 1; i++ ){
            if( maxOfLeft[i] <= minOfRight[i + 1] ){
                partitionCount++;
            }
        }

        return partitionCount + 1;
    }


    public static void main(String[] args) {
        SubseqmentSort s = new SubseqmentSort();
        System.out.println( s.subSegmentSort( new int[]{1, 0, 2, 3, 4}) );
        //System.out.println( s.maxChunksToSorted( new int[]{2, 5, 1, 9, 7, 6 }) );
    }

}
