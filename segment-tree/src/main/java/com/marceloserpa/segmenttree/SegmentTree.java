package com.marceloserpa.segmenttree;

public class SegmentTree {

    private final int size;
    private int[] tree;

    public SegmentTree(int[] elements) {
        this.size = elements.length;
        this.tree = new int[size * 2];

        System.arraycopy(elements, 0, tree, size, size);
        print(tree);

        for(int i = size-1; i>0; i--) {
            tree[i] = Math.max(tree[2*i], tree[2*i+1]);
            print(tree);
        }
    }

    public int max(int from, int to) {
        from += size;
        to += size;
        System.out.printf("from=%s to=%s%n", tree[from], tree[to]);

        if(from == to) {
            return tree[from];
        }

        int maxIndex = from;

        while(from <= to) {
            // inspect right child
            if((from & 1) == 1) {
                maxIndex = tree[maxIndex] >= tree[from] ? maxIndex : from;
                print(tree, from, to, maxIndex);
                from++;
            }

            // inspect left child
            if((to & 1) == 0) {
                maxIndex = tree[maxIndex] >= tree[to] ? maxIndex : to;
                to--;
                print(tree, from, to, maxIndex);
            }

            from /= 2;
            to /= 2;
        }

        return tree[maxIndex];
    }

    public void print(int[] elements) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < elements.length; i++) {

            sb.append(elements[i]).append(",");
        }
        System.out.println(sb.toString());
    }

    public void print(int[] elements, int start, int end, int max) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < elements.length; i++) {
            if(i == start || i == end) {
                sb.append("(").append(elements[i]).append("), ");
            } else if(i == max) {
                sb.append("<<").append(elements[i]).append(">>, ");
            } else {
                sb.append(elements[i]).append(",");
            }

        }
        System.out.println(sb.toString());
    }

}
