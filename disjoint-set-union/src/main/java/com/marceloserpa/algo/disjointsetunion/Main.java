package com.marceloserpa.algo.disjointsetunion;

public class Main {

    static void main() {

        DSUNaiveImpl dsu = new DSUNaiveImpl(10);

        //1,2,3,4,5,6,7,8,9,10

        dsu.union(5,7);
        dsu.union(6,8);
        dsu.union(5,3);
        dsu.union(6,3);
        dsu.union(3,2);
        dsu.union(4,2);
        dsu.union(2,1);

        System.out.println("=======");
        System.out.println(dsu.connect(7, 8));
        System.out.println(dsu.connect(7, 1));
        dsu.print();

    }

}
