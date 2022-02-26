import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int count;
        private int n;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    // h is proportional to log n if ordered tree

    // o(h) <-- height of tree
    public Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else if (cmp == 0) x.value = value;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    // o(h) <-- height of tree
    public Value get(Key key) {
        Node searchNode = root;
        while (searchNode != null) {
            int cmp = key.compareTo(searchNode.key);
            if (cmp < 0) searchNode = searchNode.left;
            else if (cmp > 0) searchNode = searchNode.right;
            else if (cmp == 0) return searchNode.value;
        }
        return null;
    }

    // o(h) <-- height of tree
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else if (cmp == 0) return size(x.left);
        return 0;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    // hibbard deletion

    /**
     * The main defect of Hibbard deletion is that it unbalances the three, leading to Math.sqrt(n) height.
     * <p>
     * If instead of replacing the node with its sucessor, you flip a coin and replace it with etheir its sucessor
     * or predecessor, then, in practice, the height becomes logarithmic(but nobody has able to prove this fact by math)
     */
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    // o(N)
    public Iterable<Key> iterator() {
        Queue<Key> q = new ArrayDeque<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, Queue<Key> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;

        if (cmp < 0) return floor(x.left, key);

        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    //largest key to a given key
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }


    //smallest key to a given key
    public Value ceiling(Key key) {
        return null;
    }

    public Key min() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        Node x = min(root);
        return x.key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public void deleteMin() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

}
