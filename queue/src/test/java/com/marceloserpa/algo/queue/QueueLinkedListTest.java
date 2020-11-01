package com.marceloserpa.algo.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class QueueLinkedListTest {

    @Test
    public void basicTest(){
        QueueLinkedList<String> queue = new QueueLinkedList<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
    }

    @Test
    public void test(){
        QueueLinkedList<String> queue = new QueueLinkedList<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.dequeue();
        queue.enqueue("C");

        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
    }


}
