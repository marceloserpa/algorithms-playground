package com.mserpa.tree;

public class Main {
    static void main() {

        Tree tree = new Tree(15);
        tree.add(35, new int[]{15});
        tree.add(3, new int[]{15, 35});
        tree.add(1, new int[]{15, 35, 3});
        tree.add(13, new int[]{15, 35, 3});

        System.out.println(tree);

    }
}
