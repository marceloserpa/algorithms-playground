package com.marceloserpa.algo.queue;

public interface Queue<T> {

    void enqueue(T t);

    T dequeue();

    int size();

    boolean delete(int nthElement);

}
