import edu.princeton.cs.algs4.StdRandom;

public class Quick3WayPartitioning {

    public static void sort(Comparable[] a) {
        // avoid worst case =  ~1/2 N ^2
        StdRandom.shuffle(a);

        sort(a, 0, a.length - 1);

    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return ;

        // partitioning
        int lt = lo, gt = hi; // between lt and gt will maintain the items equals pivot
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
           int cmp = a[i].compareTo(v);
           if(cmp < 0 ) exch(a, lt++, i++);
           else if (cmp > 0) exch(a, i, gt--);
           else i++;
        }

        sort(a,lo, lt-1);
        sort(a, gt+1, hi);
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
