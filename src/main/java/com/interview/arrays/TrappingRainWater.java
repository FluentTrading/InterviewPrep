package com.interview.arrays;

public class TrappingRainWater {

    //Rain water Trap + Volume of Histogram

    //Input:    [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    //LeftMax:  [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
    //RightMax: [3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]
    //Min     : [0, 1, 1, 2, 2, 2, 2, 3, 2, 2, 2, 1]
    //Min-Input:[0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0] = 6

    //Compute left max (from left), right max (from right), minimum between then and then subtract input height and add all.
    public int trap( int[] height ){

        int[] leftMax   = new int[ height.length ];
        leftMax[0] = height[0];
        for( int i=1; i<height.length; i++ ){
            leftMax[i] = Math.max( leftMax[i-1], height[i] );
        }

        int[] rightMax  = new int[ height.length ];
        rightMax[height.length-1] = height[height.length-1];
        for( int i=height.length-2; i>=0; i-- ){
            rightMax[i] = Math.max( rightMax[i+1], height[i] );
        }

        int[] minHeight = new int[ height.length ];
        for( int i=0; i<height.length; i++ ){
            minHeight[i] = Math.min( leftMax[i], rightMax[i]);
        }

        int amountOfWater = 0;
        for( int i=0; i<height.length; i++ ){
            amountOfWater += minHeight[i] - height[i];
        }

        return amountOfWater;

    }


    public static void main(String[] args) {
        TrappingRainWater r = new TrappingRainWater();
        int ampunt= r.trap( new int[]{ 4,2,0,3,2,5 });
        System.out.println( ampunt );
    }

}
