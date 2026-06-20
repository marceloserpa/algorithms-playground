package com.marceloserpa.segmenttree.merger;

import java.util.function.IntBinaryOperator;

public class SumMergeStrategy implements MergeStrategy{
    @Override
    public IntBinaryOperator merge() {
        return Integer::sum;
    }

    @Override
    public int nullNodeValue() {
        return 0;
    }
}
