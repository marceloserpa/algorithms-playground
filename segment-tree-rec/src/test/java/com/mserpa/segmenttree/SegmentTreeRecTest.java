package com.mserpa.segmenttree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTreeRecTest {


    @Test
    void max() {
        int[] elements = new int[]{6,10,5,2,7,1,0,9};
        var tree = new SegmentTreeRec(elements);
        assertEquals(10, tree.query(1, 4));
    }

    @Test
    void max_fullRange() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(10, tree.query(0, 7));
    }

    @Test
    void max_singleElement() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(6, tree.query(0, 0));
        assertEquals(10, tree.query(1, 1));
        assertEquals(7, tree.query(4, 4));
        assertEquals(9, tree.query(7, 7));
    }

    @Test
    void max_leftHalf() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(10, tree.query(0, 3));
    }

    @Test
    void max_rightHalf() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(9, tree.query(4, 7));
    }

    @Test
    void max_crossingNodes() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(7, tree.query(2, 5));
    }

    @Test
    void max_middleRange() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(10, tree.query(1, 4));
    }

    @Test
    void max_firstElements() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(10, tree.query(0, 2));
    }

    @Test
    void max_lastElements() {
        int[] elements = {6, 10, 5, 2, 7, 1, 0, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(9, tree.query(6, 7));
    }

    @Test
    void max_allEqualValues() {
        int[] elements = {5, 5, 5, 5, 5, 5};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(5, tree.query(0, 5));
        assertEquals(5, tree.query(1, 4));
        assertEquals(5, tree.query(3, 3));
    }

    @Test
    void max_negativeNumbers() {
        int[] elements = {-10, -3, -7, -20, -1};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(-1, tree.query(0, 4));
        assertEquals(-3, tree.query(0, 2));
        assertEquals(-1, tree.query(3, 4));
    }

    @Test
    void max_increasingSequence() {
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(8, tree.query(0, 7));
        assertEquals(5, tree.query(0, 4));
        assertEquals(7, tree.query(2, 6));
    }

    @Test
    void query_decreasingSequence() {
        int[] elements = {8, 7, 6, 5, 4, 3, 2, 1};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(8, tree.query(0, 7));
        assertEquals(6, tree.query(2, 4));
        assertEquals(4, tree.query(4, 7));
    }

    @Test
    void query_nonPowerOfTwoArray() {
        int[] elements = {4, 1, 8, 3, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(9, tree.query(0, 4));
        assertEquals(8, tree.query(0, 2));
        assertEquals(9, tree.query(2, 4));
    }

    @Test
    void query_withDuplicates() {
        int[] elements = {4, 9, 2, 9, 1, 9};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(9, tree.query(0, 5));
        assertEquals(9, tree.query(2, 4));
        assertEquals(9, tree.query(3, 5));
    }

    @Test
    void query_twoElements() {
        int[] elements = {3, 7};

        SegmentTreeRec tree = new SegmentTreeRec(elements);

        assertEquals(7, tree.query(0, 1));
        assertEquals(3, tree.query(0, 0));
        assertEquals(7, tree.query(1, 1));
    }

}