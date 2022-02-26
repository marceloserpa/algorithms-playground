public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int n;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size(){
        return n;
    }

    public Value get(Key key) {
        if(n == 0) return null;
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) == 0 ) {
            return values[i];
        }
        return null;
    }

    private int rank(Key key) {
        return rank(key, 0, n-1);
    }

    private int rank(Key key, int lo, int hi) {
        if(hi < lo) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp < 0) {
            return rank(key, lo, mid-1);
        } else if(cmp > 0) {
            return rank(key, mid+1, hi);
        }
        return mid;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        for(int j=n; j > i; j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }

        keys[i] = key;
        values[i] = value;
        n++;
    }
}
