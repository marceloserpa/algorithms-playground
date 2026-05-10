package com.marceloserpa.monostack;

public class MonoStack {

    private int[] elements;
    private int top = -1;

    public MonoStack(int capacity) {
        this.elements = new int[capacity];
    }

    public void push(int value){
        // make sure the values are increasing
        while(top > -1 && value < elements[top]) {
            top--;
        }
        elements[++top] = value;
    }

    public int pop(){
        return elements[top--];
    }

    public int peek(){
        return elements[top];
    }

    public int getTop(){
        return top;
    }

    public boolean isEmpty(){
        return this.top < 0;
    }

}
