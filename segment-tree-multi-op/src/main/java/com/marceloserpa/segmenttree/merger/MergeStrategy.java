package com.marceloserpa.segmenttree.merger;

import java.util.function.IntBinaryOperator;

public interface MergeStrategy {

    IntBinaryOperator merge();
    int nullNodeValue();

}
