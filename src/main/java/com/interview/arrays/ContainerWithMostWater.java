package com.interview.arrays;

public class ContainerWithMostWater {


    //Two pointer
    //Take height from left and right, advance the index
    //Calc area using min height
    //Compare to global max
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

            int reactArea =  minHeight * ((rIndx-lIndx) +1);
            maxArea = Math.max( maxArea, reactArea );
        }

        return maxArea;

    }


}
