package com.marceloserpa.leetcode1944;

public class Solution {

    public int[] canSeePersonsCount(int[] heights) {

        int[] output = new int[heights.length];

        int neighborR;
        int current;
        int max;

        for(int i =0; i < heights.length;i++) {
            neighborR = 0;
            max = 0;
            for(int j= i+1; j < heights.length; j++) {

                current = heights[j];

                if(current > max) {
                    max = current;
                }

                if(current < max) {
                    continue;
                }

                neighborR++;
                output[i] = neighborR;

                if(heights[j] > heights[i])
                    break;
            }
        }


        return output;
    }
}
