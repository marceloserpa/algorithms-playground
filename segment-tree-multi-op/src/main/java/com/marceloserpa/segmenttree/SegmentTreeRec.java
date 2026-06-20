package com.marceloserpa.segmenttree;

import com.marceloserpa.segmenttree.merger.MergeStrategy;

public class SegmentTreeRec {

    private int [] numbers;
    private int size;
    private int [] tree;

    private MergeStrategy mergeStrategy;

    public SegmentTreeRec(int[] numbers, MergeStrategy mergeStrategy) {
        this.size = numbers.length;
        this.numbers = numbers;
        this.tree = new int[size * 4];
        this.mergeStrategy = mergeStrategy;

        build(0, 0, size -1);
    }

    private void build(int parentNodeIndex, int lo, int hi){
        if(lo == hi) {
            tree[parentNodeIndex] = numbers[lo];
            return;
        }

        int mid = lo + (hi - lo) / 2;
        // calculate children nodes:  L =(2 * i +1) R=(2 * i +2)
        build(2 * parentNodeIndex + 1, lo, mid);
        build(2 * parentNodeIndex + 2, mid + 1, hi);

        tree[parentNodeIndex] = mergeStrategy.merge().applyAsInt(tree[2 * parentNodeIndex + 1], tree[2 * parentNodeIndex + 2]);
    }

    // inspiration: https://leetcode.com/articles/a-recursive-approach-to-segment-trees-range-sum-queries-lazy-propagation/
    public int query(int queryLeft, int queryRight){
        return query(0, 0, this.size -1, queryLeft, queryRight);
    }

    private int query(int parentTreeIndex, int lo, int hi, int queryLeft, int queryRight){
        if(lo > queryRight || hi < queryLeft) { // outside rangee
            return this.mergeStrategy.nullNodeValue();
        }

        if(queryLeft <= lo && queryRight >= hi) {
            return tree[parentTreeIndex];
        }

        int mid = lo + (hi - lo) / 2;
        return mergeStrategy.merge().applyAsInt(query(2 * parentTreeIndex + 1, lo, mid, queryLeft, queryRight), query(2 * parentTreeIndex + 2, mid +1 , hi, queryLeft, queryRight));
    }

    public void update(int index, int value) {
        update(0, 0, this.size - 1, index, value);
    }

    private void update(int parentTreeIndex, int lo, int hi, int index, int value) {
        if(lo == hi) {
            tree[parentTreeIndex] = value;
            return;
        }

        int mid = lo + (hi - lo) / 2;

        if(index > mid) {
            update(2 * parentTreeIndex + 2, mid + 1, hi, index, value);
        } else {
            update(2 * parentTreeIndex + 1, lo, mid, index, value);
        }

        tree[parentTreeIndex] = mergeStrategy.merge().applyAsInt(tree[2 * parentTreeIndex + 1], tree[2 * parentTreeIndex + 2]);
    }

}
