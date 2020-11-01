package com.marceloserpa.algo.stack;

public class StackArrayFixedCapacity {

    private int capacity;
    private int last;
    private String[] stack;

    public StackArrayFixedCapacity(int capacity){
        this.stack = new String[capacity];
        this.last = 0;
        this.capacity = capacity;
    }

    public void push(String value){
        if(last == capacity){
            throw new RuntimeException("Capacity exceeded");
        }
        stack[last] = value;
        last++;
    }

    public String pop(){
        String removed = stack[--last];
        stack[last] = null; // This implementation avoid LOITERING
        return removed;
    }

    public static void main(String[] args) {
        StackArrayFixedCapacity stack = new StackArrayFixedCapacity(5);
        stack.push("5");
        stack.push("4");
        stack.push("3");
        System.out.println(stack.pop());
        stack.push("2");
        stack.push("1");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
