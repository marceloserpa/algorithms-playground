package com.marceloserpa.segmenttree.merger;

public class MergeStrategyFactory {

    public static MergeStrategy max() {
        return new MaxMergeStrategy();
    }

    public static MergeStrategy min(){
        return new MinMergeStrategy();
    }

    public static MergeStrategy sum(){
        return new SumMergeStrategy();
    }
}
