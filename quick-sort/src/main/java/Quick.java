import edu.princeton.cs.algs4.StdRandom;

public class Quick {

    public static void sort(Comparable[] a) {
        // avoid worst case =  ~1/2 N ^2
        StdRandom.shuffle(a);

        sort(a, 0, a.length - 1);

    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return ;

        int j = partition(a, lo, hi);
        sort(a,lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi+1;

        while(true) {
            // find item on left to swap
            while(less(a[++i], a[lo])){
                if(i == hi) break;
            }

            // find item on right to swap
            while (less(a[lo], a[--j])){
                if(j == lo)  break;
            }

            //check if pointers cross
            if(i >= j ) break;

            // swap
            exch(a, i, j);
        }

        // swap with partitioning item
        exch(a, lo, j);

        // index of item now know to be in place
        return j;

    }

    private static void exch(Comparable[] comparables, int i,int j){
        Comparable t = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = t;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }




}
