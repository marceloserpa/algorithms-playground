package com.marceloserpa.segmenttree;

public class Main {
    static void main() {

        int[] elements = new int[]{6,10,5,2,7,1,0,9};
        var st = new SegmentTree(elements);
        var max = st.max(1, 6); // index
        System.out.println(max);
    }
}
