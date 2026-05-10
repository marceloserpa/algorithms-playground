package com.marceloserpa.leetcode1944;

public class Solution2 {

    static class Stack {

        private int[] elements;
        private int top = -1;

        public Stack(int capacity){
            elements = new int[capacity];
        }

        public void push(int value) {
            elements[++top] = value;
        }

        public int pop(){
            return elements[top--];
        }

        public int peek(){
            return elements[top];
        }

        public boolean isEmpty(){
            return top < 0;
        }

    }

    public int[] canSeePersonsCount(int[] heights) {

        int n = heights.length;

        Stack stack = new Stack(n);
        int visiblePeople = 0;

        int[] output = new int[n];

        for(int i = n-1; i >= 0; i--) {

            // cleaning visible people counter
            visiblePeople = 0;

            // heights[i] greater than stack top position means the new entry is taller
            // so the person on top of stack with NOT be visible after the insertion of new entry
            // this is why we need to pop the top element from stack and increase the visible people
            // counter since the element is visible by new entry
            while(!stack.isEmpty() && stack.peek() < heights[i]){
                stack.pop();
                visiblePeople++;
            }

            // The previous while removed all elements lower than new entry it means if the stack is not empty
            // the new element will be able to see one more element.
            if(!stack.isEmpty()) {
                visiblePeople++;
            }

            // add the new entry
            stack.push(heights[i]);
            output[i] = visiblePeople;
        }


        return output;
    }

}
