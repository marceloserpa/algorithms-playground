package com.marceloserpa.algo.queue;

public class QueueLinkedList<T> {

    private Node head;
    private Node last;

    private class Node {

        public Node(T value){
            this.value = value;
        }

        public Node(T t, Node next){
            this.value = t;
            this.next = next;
        }

        T value;
        Node next;
    }

    public void enqueue(T value){
        Node oldLast = last;
        last = new Node(value);

        if(head == null) {
            head = last;
        } else {
            oldLast.next = last;
        }
    }

    public T dequeue(){
        Node oldHead = head;
        head = oldHead.next;
        return oldHead.value;
    }



}
