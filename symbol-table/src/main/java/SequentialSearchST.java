public class SequentialSearchST<Key, Value> {

    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // O(n)
    public void put(Key key, Value value) {
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) {
                // update the find value
                x.value = value;
            }
        }

        // add missing node
        first = new Node(key, value, first);
    }

    // O(n)
    public Value get(Key key) {
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }


}
