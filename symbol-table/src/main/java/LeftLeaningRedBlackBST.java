import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class LeftLeaningRedBlackBST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {

        private static final boolean RED = true;
        private static final boolean BLACK = false;

        private Key key;
        private Value value;
        private Node left, right;
        private int count;
        private boolean color; // color of parent link

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }



    }

    private boolean isRed(Node x) {
        if (x == null) return false; // null links are black
        return x.color == Node.RED;
    }

    /**
     * Orient a (temporarily)right-leaning red link to lean left
     * this operation maintain symmetric order and perfect black balance
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        h.color = Node.RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = h.right;
        x.right = h;
        x.color = h.color;

        h.color = Node.RED;
        return x;
    }


    /**
     * Recolor to split a (temporary) 4-node
     */
    private void flipColors(Node h) {
        h.color = Node.RED;
        h.left.color = Node.BLACK;
        h.right.color = Node.BLACK;
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

    public Node put(Node h, Key key, Value value) {
        // insert at bottom (and color red)
        if (h == null) return new Node(key, value, Node.RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, value);
        else if (cmp > 0) h.right = put(h.right, key, value);
        else if (cmp == 0) h.value = value;


        // start - this block of code provides near-perfect balance
        // lean left
        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);

        // balance 4-node
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);

        // split 4-node
        if(isRed(h.left) && isRed(h.right)) flipColors(h);
        // end

        return h;
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
        return x;
    }

}