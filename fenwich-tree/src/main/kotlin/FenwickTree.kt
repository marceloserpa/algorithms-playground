package com.marceloserpa

class FenwickTree(private var capacity: Int) {

    // binary indexed tree
    // added +1 because the position 0 will be ignored
    private var BIT: IntArray = IntArray(capacity + 1){0};

    fun putValue(index: Int, value: Int) {
        var localIndex = index + 1;
        do {
            BIT[localIndex] = BIT[localIndex] + value
            localIndex += lowBit(localIndex)
        } while (localIndex <= capacity)
        println(BIT.contentToString())
    }

    private fun lowBit(i: Int): Int = i and -i

    fun sum(index: Int): Int {
        var sum: Int = 0
        var localIndex = index;
        while (localIndex > 0) {
            println("lowBit = ${lowBit(localIndex)} currentIndex = ${localIndex} value = ${BIT[localIndex]}")
            sum += BIT[localIndex]
            localIndex -= lowBit(localIndex)
        }
        return sum
    }

    fun range(start: Int, end: Int): Int {
        return sum(end) - sum(start)
    }
}