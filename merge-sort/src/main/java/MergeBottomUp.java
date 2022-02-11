public class MergeBottomUp {

    private static final int CUTOFF = 5;


    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        Comparable[] aux = new Comparable[a.length];
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];


        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)               a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }

    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void sort(Comparable[] a) {

        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for(int sz =1; sz < n; sz = sz+sz) {
            for (int lo = 0; lo < n - sz; lo += sz+sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, n - 1));
            }
        }

    }



}
