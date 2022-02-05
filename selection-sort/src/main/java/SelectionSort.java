public class SelectionSort {

    public static void sort(Comparable[] comparables){
        for(int i = 0; i < comparables.length; i++){
            int min = i;
            for(int j = i+1;j < comparables.length; j++){
                if(less(comparables[j], comparables[min])) {
                    min = j;
                }
                exchange(comparables, i, min);
            }
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
