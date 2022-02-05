import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private static final int INITIAL_CAPACITY = 5;

    private Item[] items;
    private int capacity;
    private int lastIndex;


    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        lastIndex = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return lastIndex == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return lastIndex;
    }

    // add the item
    public void enqueue(Item item) {
        if(item == null) {
            throw new IllegalArgumentException("Cannot enqueue null element");
        }
        if(lastIndex >= (capacity - 1)) { // should resize
            capacity = capacity * 2;
            Item[] newArray = (Item[]) new Object[capacity];
            for(int i = 0; i < items.length; i++) {
                newArray[i] = items[i];
            }
            items = newArray;
        }
        items[lastIndex] = item;
        lastIndex++; // move to cursor to the next element

    }

    // remove and return a random item
    public Item dequeue() {
        if(lastIndex == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        int index = StdRandom.uniform(0, lastIndex);
        Item element = items[index];
        items[index] = items[lastIndex - 1];
        items[lastIndex - 1] = null; // avoid loitering
        lastIndex--;
        return element;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if(lastIndex == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        int index = StdRandom.uniform(0, size());
        return items[index];
    }


    private class ElementIterator implements Iterator<Item> {

        int current = 0;

        @Override
        public boolean hasNext() {
            return current < lastIndex;
        }

        @Override
        public Item next() {
            if(lastIndex == 0 || current > lastIndex) {
                throw new NoSuchElementException("The iterator has no more elements");
            }
            Item value = items[current];
           current++;
            return value;
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ElementIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {

        RandomizedQueue<Integer> numbers = new RandomizedQueue<>();
        numbers.enqueue(1);
        numbers.enqueue(2);
        numbers.enqueue(3);
        numbers.enqueue(4);
        StdOut.println("size = " + numbers.size());
        numbers.enqueue(5);
        StdOut.println("size = " + numbers.size());
        numbers.enqueue(6);
        StdOut.println("size = " + numbers.size());
        StdOut.println("sample = " + numbers.sample());
        StdOut.println("size = " + numbers.size());
        StdOut.println("removed = " + numbers.dequeue());
        StdOut.println("size = " + numbers.size());
        StdOut.println("sample = " + numbers.sample());
        StdOut.println("size = " + numbers.size());


        Iterator<Integer> iterator = numbers.iterator();
        StdOut.println(iterator.next());
        StdOut.println(iterator.next());
        StdOut.println(iterator.next());
        StdOut.println(iterator.next());
        StdOut.println(iterator.next());
        StdOut.println(iterator.next());
    }

}