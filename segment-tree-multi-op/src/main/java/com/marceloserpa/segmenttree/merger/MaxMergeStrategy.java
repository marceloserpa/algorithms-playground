package com.marceloserpa.segmenttree.merger;

import java.util.function.IntBinaryOperator;

public class MaxMergeStrategy implements MergeStrategy{
    @Override
    public IntBinaryOperator merge() {
        return Math::max;
    }

    @Override
    public int nullNodeValue() {
        return Integer.MIN_VALUE;
    }
}
