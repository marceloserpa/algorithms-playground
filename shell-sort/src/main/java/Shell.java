public class Shell {

    public static void sort(Comparable[] a){

        int n = a.length;
        int h = 1;

        while (h < n/3) {
            h = 3 * h + 1;
            System.out.println(h);
        }
        System.out.println("h = " + 1);

        while (h >= 1 ) {
            for(int i = h; i < n; i++) {
                for(int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exchange(a, j, j-h);
                }
            }

            h = h / 3;
            System.out.println("h=" + h);
        }

    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] comparables, int i,int j){
        Comparable t = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = t;
    }

}