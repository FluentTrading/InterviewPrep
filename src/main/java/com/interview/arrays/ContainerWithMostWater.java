package com.interview.arrays;

public class ContainerWithMostWater {

    /**
        You are given an array of heights. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
        Find two lines that together with the x-axis form a container, such that the container contains the most water.
     */

    //Two pointer approach:
    //Take height from left and right, calculate area using min height (as the container is defined by the smaller height)
    //Keep comparing and updating to global max
    public int maxArea( int[] height ){

        int maxArea = 0;
        int lIndx = 0;
        int rIndx = height.length - 1;

        while( lIndx < rIndx ){

            int leftHeight  = height[lIndx];
            int rightHeight = height[rIndx];

            int minHeight   = 1;
            if( leftHeight <= rightHeight ){
                minHeight = leftHeight;
                ++lIndx;
            }else{
                --rIndx;
                minHeight = rightHeight;
            }

            int thisArea =  minHeight * ((rIndx-lIndx) +1);
            maxArea = Math.max( maxArea, thisArea );
        }

        return maxArea;

    }


}
