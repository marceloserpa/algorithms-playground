package com.marceloserpa.algo.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class QueueResizeArrayTest {

    @Test
    public void basicTest(){
        Queue<String> queue = new QueueResizeArray<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
    }

    @Test
    public void test(){
        Queue<String> queue = new QueueResizeArray<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.dequeue();
        queue.enqueue("C");

        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
    }

    @Test
    public void testSizeQueue(){
        Queue<String> queue = new QueueResizeArray<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.dequeue();
        queue.enqueue("C");

        assertEquals(2, queue.size());
    }

    @Test
    public void testRemoveNthELementFromQueue(){
        Queue<String> queue = new QueueResizeArray<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        queue.delete(2);

        assertEquals("A", queue.dequeue());
        assertEquals("C", queue.dequeue());
    }

    @Test
    public void testRemoveLastELementFromQueue(){
        Queue<String> queue = new QueueResizeArray<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        queue.delete(3);

        assertEquals(2, queue.size());
    }

    @Test
    public void testRemoveFirstELementFromQueue(){
        Queue<String> queue = new QueueResizeArray<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        queue.delete(1);

        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
    }

    @Test
    public void testDeleteFirstElementAfterDequeue(){
        Queue<String> queue = new QueueResizeArray<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");

        queue.dequeue();
        queue.dequeue();

        queue.delete(1);

        assertEquals("D", queue.peek());
    }

    @Test
    public void testDeleteSecondElementAfterDequeue(){
        Queue<String> queue = new QueueResizeArray<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");

        queue.dequeue();
        queue.dequeue();

        queue.delete(2);

        assertEquals("C", queue.peek());
    }

}
