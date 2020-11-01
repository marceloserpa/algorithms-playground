package com.marceloserpa.algo.stack;

public class StackOfStringLinkedList {

    private Node first;

    // 16 bytes (Object overhead)
    private class Node { // 8 bytes (inner class extra overhead)

        String value; // 8 bytes (reference to String)
        Node next; // 8 bytes (reference Node)

        public Node(String value){
            this.value = value;
        }

        public Node(String value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void push(String text){
        if(first == null){
            first = new Node(text);
        } else {
            Node second = first;
            first = new Node(text, second);
        }
    }

    public String pop(){
        Node removed = first;
        first = removed.next;
        return removed == null ? null : removed.value;
    }


    public static void main(String[] args) {
        StackOfStringLinkedList stack = new StackOfStringLinkedList();
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
