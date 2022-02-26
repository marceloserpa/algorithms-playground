public class BST <Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public void put(Key key, Value value) {
           root = put(root, key, value);
        }

        public Node put(Node x, Key key, Value value) {
           if(x == null) return new Node(key, value);
           int cmp = key.compareTo(x.key);
           if(cmp < 0) x.left = put(x.left, key, value);
           else if(cmp > 0) x.right = put(x.right, key, value);
           else if(cmp == 0) x.value = value;
           return x;
        }


        public Value get(Key key) {
            Node searchNode = root;
            while(searchNode != null) {
                int cmp = key.compareTo(searchNode.key);
                if(cmp < 0) searchNode = searchNode.left;
                else if(cmp > 0) searchNode = searchNode.left;
                else if(cmp == 0) return searchNode.value;
            }
            return null;
        }

        public void delete(Key key){

        }

        public Iterable<Key> iterator(){
            
        }

        private Key floor(Key key) {
             Node x = floor(root, key);
             if(x == null) return null;
             return x.key;
        }

        private Node floor(Node x, Key key) {
            if(x == null) return null;
            int cmp = key.compareTo(x.key);
            if(cmp == 0) return x;

            if(cmp < 0) return floor(x.left, key);

            Node t = floor(x.right, key);
            if(t != null) return t;
            else return x;
        }

        //largest key to a given key
        public Key floor(Key key){

        }

        //smallest key to a given key
        public Value ceiling(Key key) {

        }

    }



}
