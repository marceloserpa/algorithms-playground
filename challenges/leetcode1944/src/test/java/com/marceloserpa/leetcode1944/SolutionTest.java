package com.marceloserpa.leetcode1944;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void testCase1(){
        int[] heights = new int[]{5,1,2,3,10};

        Solution solution = new Solution();
        int[] output = solution.canSeePersonsCount(heights);

        printArray(heights);
        printArray(output);


        assertArrayEquals(new int[]{4,1,1,1,0}, output);
    }

    @Test
    public void testCase2(){
        int[] heights = new int[]{10,6,8,5,11,9};

        Solution solution = new Solution();
        int[] output = solution.canSeePersonsCount(heights);

        printArray(heights);
        printArray(output);


        assertArrayEquals(new int[]{3,1,2,1,1,0}, output);
    }

    @Test
    public void testCase3(){
        int[] heights = new int[]{11,19,12,15,14,18,7,1,8,9};

        Solution solution = new Solution();
        int[] output = solution.canSeePersonsCount(heights);

        printArray(heights);
        printArray(output);


        assertArrayEquals(new int[]{1,3,1,2,1,3,2,1,1,0}, output);


    }


    void printArray(int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(",");
        }
        System.out.println(sb.toString());
    }

}