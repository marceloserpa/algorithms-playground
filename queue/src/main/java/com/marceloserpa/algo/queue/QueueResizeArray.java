package com.marceloserpa.algo.queue;


@SuppressWarnings("unchecked")
public class QueueResizeArray<T> implements Queue<T> {

    private final static int INITIAL_CAPACITY = 2;

    private int front;
    private int rear;
    private T[] queue;

    public QueueResizeArray() {
        front = 0;
        rear = 0;
        queue = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public T peek() {
        return queue[front];
    }

    @Override
    public void enqueue(T element) {
        if(rear == queue.length){
            resize(queue.length * 2);
        }
        queue[rear++] = element;
    }

    private void resize(int newCapacity){
        T[] newQueue = (T[]) new Object[newCapacity];

        int newQueueIndex = 0;
        for(int i = front; i < rear; i++){
            newQueue[newQueueIndex++] = queue[i];
        }
        rear = rear - front;
        front = 0;
        queue = newQueue;
    }

    public void printInternalStructure(){
        for(int i = 0; i < queue.length; i++){
            System.out.println(i + " = " + queue[i]);
        }
    }

    @Override
    public T dequeue() {
        T element = queue[front];
        queue[front] = null;
        front++;
        return element;
    }

    @Override
    public int size() {
        System.out.println("rear = " + rear + "; front="+front);
        return rear - front;
    }

    @Override
    public boolean delete(int nthElement) {
        int index = front + ( nthElement - 1);
        if(index == front){
            queue[front] = null;
            front++;
        }  else {
            for(int i = index; i < rear; i++){
                queue[i] = queue[i+1];
            }
            queue[rear] = null;
            rear--;
        }

        return true;
    }

}
