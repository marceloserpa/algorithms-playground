package com.marceloserpa

class FenwickTree(var capacity: Int) {

    var tree: IntArray = IntArray(capacity + 1){0};

    fun putValue(index: Int, value: Int) {
        var localIndex = index + 1;
        do {
            tree[localIndex] = tree[localIndex] + value
            localIndex += lowBit(localIndex)
        } while (localIndex <= capacity)
        println(tree.contentToString())
    }

    fun lowBit(i: Int): Int = i and -i

}


fun main() {

    val numbers: IntArray = intArrayOf(5,2,9,-3,5,20,10,-7,2,3,-4,0,-2,15,5)
    val ft  = FenwickTree(numbers.size)
    for(i in numbers.indices) {
        ft.putValue(i,numbers[i])
    }

    println(ft.tree.contentToString())

}