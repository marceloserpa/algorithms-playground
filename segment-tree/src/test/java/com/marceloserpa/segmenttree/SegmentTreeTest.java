package com.marceloserpa.segmenttree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTreeTest {

    @Test
    void max() {
        int[] elements = new int[]{6,10,5,2,7,1,0,9};
        var tree = new SegmentTree(elements);
        assertEquals(10, tree.max(1, 4));
    }

    @Test
    void max_fullRange() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(10, tree.max(0, 7));
    }

    @Test
    void max_singleElement() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(6, tree.max(0, 0));
        assertEquals(10, tree.max(1, 1));
        assertEquals(7, tree.max(4, 4));
        assertEquals(9, tree.max(7, 7));
    }

    @Test
    void max_leftHalf() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(10, tree.max(0, 3));
    }

    @Test
    void max_rightHalf() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(9, tree.max(4, 7));
    }

    @Test
    void max_crossingNodes() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(7, tree.max(2, 5));
    }

    @Test
    void max_middleRange() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(10, tree.max(1, 4));
    }

    @Test
    void max_firstElements() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(10, tree.max(0, 2));
    }

    @Test
    void max_lastElements() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(9, tree.max(6, 7));
    }

    @Test
    void max_allEqualValues() {
        int[] elements = {5, 5, 5, 5, 5, 5};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(5, tree.max(0, 5));
        assertEquals(5, tree.max(1, 4));
        assertEquals(5, tree.max(3, 3));
    }

    @Test
    void max_negativeNumbers() {
        int[] elements = {-10, -3, -7, -20, -1};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(-1, tree.max(0, 4));
        assertEquals(-3, tree.max(0, 2));
        assertEquals(-1, tree.max(3, 4));
    }

    @Test
    void max_increasingSequence() {
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(8, tree.max(0, 7));
        assertEquals(5, tree.max(0, 4));
        assertEquals(7, tree.max(2, 6));
    }

    @Test
    void max_decreasingSequence() {
        int[] elements = {8, 7, 6, 5, 4, 3, 2, 1};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(8, tree.max(0, 7));
        assertEquals(6, tree.max(2, 4));
        assertEquals(4, tree.max(4, 7));
    }

    @Test
    void max_nonPowerOfTwoArray() {
        int[] elements = {4, 1, 8, 3, 9};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(9, tree.max(0, 4));
        assertEquals(8, tree.max(0, 2));
        assertEquals(9, tree.max(2, 4));
    }

    @Test
    void max_withDuplicates() {
        int[] elements = {4, 9, 2, 9, 1, 9};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(9, tree.max(0, 5));
        assertEquals(9, tree.max(2, 4));
        assertEquals(9, tree.max(3, 5));
    }

    @Test
    void max_twoElements() {
        int[] elements = {3, 7};

        SegmentTree tree = new SegmentTree(elements);

        assertEquals(7, tree.max(0, 1));
        assertEquals(3, tree.max(0, 0));
        assertEquals(7, tree.max(1, 1));
    }
}