

public class Insertion {

    public static void sort(Comparable[] comparables){
        for(int i = 0; i < comparables.length; i++){
            for(int j = i; j > 0; j--){
                if(less(comparables[j], comparables[j-1])) {
                    exchange(comparables, j, j-1);
                } else {
                    break;
                }
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