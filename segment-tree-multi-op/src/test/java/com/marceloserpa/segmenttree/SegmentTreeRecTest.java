package com.marceloserpa.segmenttree;

import com.marceloserpa.segmenttree.merger.MergeStrategyFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTreeRecTest {

    @Test
    void max() {
        int[] elements = new int[]{6,10,5,2,7,1,0,9};
        var tree = new SegmentTreeRec(elements, MergeStrategyFactory.max());
        assertEquals(10, tree.query(1, 4));
    }

    @Test
    void max_fullRange() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements, MergeStrategyFactory.max());

        assertEquals(10, tree.query(0, 7));
    }

    @Test
    void min() {
        int[] elements = new int[]{6,10,5,2,7,1,0,9};
        var tree = new SegmentTreeRec(elements, MergeStrategyFactory.min());
        assertEquals(2, tree.query(1, 4));
    }

    @Test
    void min_fullRange() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements, MergeStrategyFactory.min());

        assertEquals(0, tree.query(0, 7));
    }

    @Test
    void sum() {
        int[] elements = new int[]{6,10,5,2,7,1,0,9};
        var tree = new SegmentTreeRec(elements, MergeStrategyFactory.sum());
        assertEquals(24, tree.query(1, 4));
    }

    @Test
    void sum_fullRange() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements, MergeStrategyFactory.sum());

        assertEquals(40, tree.query(0, 7));
    }
}