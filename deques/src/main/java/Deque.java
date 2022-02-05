import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int size;

    // construct an empty deque
    public Deque() {
        first = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }


    // return the number of items on the deque
    public int size() {
        return this.size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if(item == null) {
            throw  new IllegalArgumentException("item cannot be null");
        }
        Node<Item> itemNode = new Node<>();
        itemNode.setValue(item);
        itemNode.setPrev(null);
        if(first == null) {
            first = itemNode;
        } else {
            first.setPrev(itemNode);
            itemNode.setNext(first);
            first = itemNode;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if(item == null) {
            throw  new IllegalArgumentException("item cannot be null");
        }
        Node<Item> itemNode = new Node<>();
        itemNode.setValue(item);
        itemNode.setPrev(null);
        if(first == null) {
            first = itemNode;
        } else {
            Node<Item> element = first;
            while(element.next != null) {
                element = element.next;
            }
            element.setNext(itemNode);
            itemNode.setPrev(element);
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if(first == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        Item element = first.value;
        first = first.next;
        size--;
        return element;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if(first == null) {
            throw new NoSuchElementException("Queue is empty");
        }

        if(size == 1 ){
            Item value = first.value;
            size--;
            first = null;
            return value;
        }
        Node<Item> lastElement = first;
        while(lastElement.next != null) {
            lastElement = lastElement.next;
        }
        Item lastValue = lastElement.value;

        Node prev = lastElement.getPrev();
        if(prev != null) {
            prev.setNext(null);
        }
        lastElement = null;
        this.size--;

        return lastValue;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ElementIterator();
    }

    private class Node<Item> {

        private Node next;
        private Node prev;
        private Item value;

        public Node() {
        }

        public Node(Node next, Node prev, Item value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Item getValue() {
            return value;
        }

        public void setValue(Item value) {
            this.value = value;
        }
    }

    private class ElementIterator implements Iterator<Item> {

        private Node<Item> current;

        public ElementIterator(){
            current = first;
        }
        @Override
        public boolean hasNext() {
            return current != null
                   // && current.next != null;
            ;
        }

        @Override
        public Item next() {
            if(current == null) {
                throw new NoSuchElementException("The iterator has no more elements");
            }
            Item value = current.getValue();
            current = current.getNext();
            return value;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}