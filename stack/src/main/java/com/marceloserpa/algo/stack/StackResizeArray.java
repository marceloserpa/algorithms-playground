package com.marceloserpa.algo.stack;

public class StackResizeArray {

    private final static int STACK_CAPACITY = 2;

    private int last;
    private String[] stack;

    public StackResizeArray(){
        stack = new String[STACK_CAPACITY];
        last = 0;
    }

    public void push(String value){
        if(last == stack.length){
            resize(stack.length * 2);
        }
        stack[last++] = value;
    }

    private void resize(int newCapacity){
       System.out.println("Resize from " + stack.length + " to " + newCapacity);
       String[] temp = new String[newCapacity];
       for(int i = 0; i < last; i++){
           temp[i] = stack[i];
       }
       stack = temp;
    }

    public String pop(){
        String removed = stack[--last];
        stack[last] = null; // This implementation avoid LOITERING
        if(last > 0 && last == stack.length / 4){
            // Shrink array
            // halve size of array stack when array is one-quarter full
            resize(stack.length / 2);
        }
        return removed;
    }

    public static void main(String[] args) {
        StackResizeArray stack = new StackResizeArray();
        stack.push("5");
        stack.push("4");
        stack.push("3");
        System.out.println(stack.pop());
        stack.push("2");
        stack.push("1");
        stack.push("0");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }


}
