import java.util.Iterator;

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
        return null;
    }

    // remove and return the item from the back
    public Item removeLast() {
        return null;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return null;
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

    // unit testing (required)
    public static void main(String[] args) {

    }

}