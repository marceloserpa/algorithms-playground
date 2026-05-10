package com.marceloserpa.leetcode1944;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution2Test {

    @Test
    public void testCase1(){
        int[] heights = new int[]{5,1,2,3,10};

        Solution2 solution = new Solution2();
        int[] output = solution.canSeePersonsCount(heights);

        printArray(heights);
        printArray(output);


        assertArrayEquals(new int[]{4,1,1,1,0}, output);
    }

    @Test
    public void testCase2(){
        int[] heights = new int[]{10,6,8,5,11,9};

        Solution2 solution = new Solution2();
        int[] output = solution.canSeePersonsCount(heights);

        printArray(heights);
        printArray(output);


        assertArrayEquals(new int[]{3,1,2,1,1,0}, output);
    }

    @Test
    public void testCase3(){
        int[] heights = new int[]{11,19,12,15,14,18,7,1,8,9};

        Solution2 solution = new Solution2();
        int[] output = solution.canSeePersonsCount(heights);

        printArray(heights);
        printArray(output);


        assertArrayEquals(new int[]{1,3,1,2,1,3,2,1,1,0}, output);


    }

    @Test
    public void testCase4(){
        int[] heights = new int[]{10, 6, 8, 5, 4, 3, 2, 10, 9};

        Solution2 solution = new Solution2();
        int[] output = solution.canSeePersonsCount(heights);

        printArray(heights);
        printArray(output);

        assertArrayEquals(new int[]{3,1,2,2,2,2,1,1,0}, output);

    }

    //

    @Test
    public void testCase5(){
        int[] heights = new int[]{10, 6, 8, 2, 3, 4, 5, 10, 9};

        Solution2 solution = new Solution2();
        int[] output = solution.canSeePersonsCount(heights);

        printArray(heights);
        printArray(output);

        assertArrayEquals(new int[]{3,1,5,1,1,1,1,1,0}, output);

    }

    //


    void printArray(int[] arr){
        StringBuilder sb = new StringBuilder();
        for (Integer i : arr) {
            sb.append(i).append(",");
        }
        System.out.println(sb.toString());
    }

}