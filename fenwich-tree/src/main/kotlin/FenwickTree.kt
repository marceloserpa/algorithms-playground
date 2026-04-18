package com.marceloserpa

class FenwickTree(var capacity: Int) {

    // binary indexed tree
    // added +1 because the position 0 will be ignored
    var BIT: IntArray = IntArray(capacity + 1){0};

    fun putValue(index: Int, value: Int) {
        var localIndex = index + 1;
        do {
            BIT[localIndex] = BIT[localIndex] + value
            localIndex += lowBit(localIndex)
        } while (localIndex <= capacity)
        println(BIT.contentToString())
    }

    fun lowBit(i: Int): Int = i and -i

    fun sum(index: Int): Int {
        var sum: Int = 0
        var localIndex = index;
        while (localIndex > 0) {
            println("read index ${localIndex} = ${BIT[localIndex]}")
            sum += BIT[localIndex]
            localIndex -= lowBit(localIndex)
        }
        return sum
    }

    fun range(start: Int, end: Int): Int {
        return sum(end) - sum(start)
    }
}


fun main() {

    val numbers: IntArray = intArrayOf(5,2,9,-3,5,20,10,-7,2,3,-4,0,-2,15,5)
    val ft  = FenwickTree(numbers.size)
    for(i in numbers.indices) {
        ft.putValue(i,numbers[i])
    }

    //println(ft.sum(8))
    //println(ft.sum(3))
    //println(ft.sum(5))

    println(ft.range(4, 7))
    println(ft.BIT.contentToString())

}