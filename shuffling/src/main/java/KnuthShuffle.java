import java.util.Random;
import java.util.stream.IntStream;

public class KnuthShuffle {

    public static void main(String[] args) {
        int[] a = IntStream.range(1, 10).toArray();

        System.out.println("# Biased Shuffle");
        naiveShuffle(a);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

        int[] b = IntStream.range(1, 10).toArray();
        System.out.println("# Knuth Shuffle");
        KFYShuffle(b);
        for(int i = 0; i < a.length; i++){
            System.out.println(b[i]);
        }
    }

    public static void KFYShuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            // Knuth-Fisher-Yates Shuffle https://spin.atomicobject.com/2014/08/11/fisher-yates-shuffle-randomization-algorithm/
            int r = random(0, i +1);
            exchange(a, i, r);
        }
    }

    public static void naiveShuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = random(0, n);
            exchange(a, i, r);
        }
    }

    private static int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    private static void exchange(int[] elements, int i,int j){
        System.out.println("change " + elements[i] + " - " + elements[j]);
        int t = elements[i];
        elements[i] = elements[j];
        elements[j] = t;
    }

}
