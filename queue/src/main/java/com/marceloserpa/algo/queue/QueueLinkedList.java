package com.marceloserpa.algo.queue;

public class QueueLinkedList<T> implements Queue<T>{

    private Node head;
    private Node last;
    private int size = 0;

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
        size++;
    }

    public T dequeue(){
        Node oldHead = head;
        head = oldHead.next;
        size--;
        return oldHead.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean delete(int nthElement) {
        if(nthElement > size) {
            throw new RuntimeException("You cannot delete position outsize the queue size");
        }
        if(nthElement == 1) {
            head = head.next;
            size--;
            return true;
        }

        int beforeIndex = nthElement -1;
        Node beforeElement = head;

        int i = 1;
        while(i < beforeIndex){
            beforeElement = beforeElement.next;
            i++;
        }
        beforeElement.next = beforeElement.next.next;

        return true;
    }


}
