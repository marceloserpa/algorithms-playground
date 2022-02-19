public class UnorderedMaxPQ <T extends  Comparable<T>> {

    private T[] priorityQueue;
    private int size;

    public UnorderedMaxPQ(int capacity) {
        priorityQueue = (T[]) new Comparable[capacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(T element) {
        priorityQueue[size++] = element;
    }

    public T delMax(){
        int max = 0;
        for(int i = 1; i < size; i++) {
            if(less(max, i)) max = i;
        }
        exch(max, size-1);
        return priorityQueue[--size];
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
