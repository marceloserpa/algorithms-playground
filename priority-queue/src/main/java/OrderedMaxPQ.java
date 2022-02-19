
// Priority Queue implemented using Binary Heap
public class OrderedMaxPQ<T extends  Comparable<T>> {

    private T[] priorityQueue;
    private int size;

    public OrderedMaxPQ(int capacity) {
        priorityQueue = (T[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(T element) {
        priorityQueue[++size] = element;
        swim(size);
    }

    public T delMax(){
        T max = priorityQueue[1];
        exch(1, size--);
        sink(1);
        priorityQueue[size+1] = null; // prevent loitering
        return max;
    }

    private void sink(int k) {
        while(2 * k <= size) {
            int j = 2*k;
            if(j < size && less(j, j+1)) j++;
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }


    private void swim(int k) {
        while(k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void exch(int i,int j){
        T t = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = t;
    }

    private boolean less(int v, int w){
        return priorityQueue[v].compareTo(priorityQueue[w]) < 0;
    }

}
