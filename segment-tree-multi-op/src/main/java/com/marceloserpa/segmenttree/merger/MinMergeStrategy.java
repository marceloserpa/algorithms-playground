package com.marceloserpa.segmenttree.merger;

import java.util.function.IntBinaryOperator;

public class MinMergeStrategy implements MergeStrategy{
    @Override
    public IntBinaryOperator merge() {
        return Math::min;
    }

    @Override
    public int nullNodeValue() {
        return Integer.MAX_VALUE;
    }
}

