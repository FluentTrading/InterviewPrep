package com.interview.arrays;

import java.util.Arrays;

public class TrappingRainWater {

    //Rain water Trap + Volume of Histogram

    //Input:    [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    //LeftMax:  [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
    //RightMax: [3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]
    //Min     : [0, 1, 1, 2, 2, 2, 2, 3, 2, 2, 2, 1]
    //Min-Input:[0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0] = 6
    public int trap( int[] height ){

        int[] leftMax   = new int[ height.length ];
        leftMax[0] = height[0];
        for( int i=1; i<height.length; i++ ){
            leftMax[i] = Math.max( height[i], leftMax[i-1] );
        }
        System.out.println("Left: " + Arrays.toString(leftMax));

        int[] rightMax  = new int[ height.length ];
        rightMax[height.length-1] = height[height.length-1];
        for( int i=height.length-2; i>=0; i-- ){
            rightMax[i] = Math.max( height[i], rightMax[i+1] );
        }
        System.out.println("Right: " + Arrays.toString(rightMax));

        int[] min       = new int[ height.length ];
        for( int i=0; i<height.length; i++ ){
            min[i] = Math.min( leftMax[i], rightMax[i]);
        }
        System.out.println("Min: " + Arrays.toString(min));

        int amountOfWater = 0;
        for( int i=0; i<height.length; i++ ){
            amountOfWater += min[i] - height[i];
        }
        //System.out.println("Min: " + Arrays.toString(min));

        return amountOfWater;
    }


    public static void main(String[] args) {
        TrappingRainWater r = new TrappingRainWater();
        int ampunt= r.trap( new int[]{ 4,2,0,3,2,5 });
        System.out.println( ampunt );
    }

}
