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

            // clean visible people
            visiblePeople = 0;

            // heights[i] greater than stack first position means the new entry is taller the value return in peek()
            // so the person in on top of stack with NOT be visible after the insertion of new entry
            // this is why we need to pop the current values from stack and call it as visible (by taller entry)
            while(!stack.isEmpty() && stack.peek() < heights[i]){
                stack.pop();
                visiblePeople++;
            }

            // if the stack is not empty, it means we have an element inside stack, as the previous while remove
            // values lower than new entry we have sure current element on stack is visible.
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
