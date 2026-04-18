package com.marceloserpa

class SimpleSumArray (val size: Int) {

    var numbers: IntArray = IntArray(size){0};
    var preComputed: IntArray = IntArray(size){0};
    var lastIndex = 0;

    fun insert(value:Int) {
        if(lastIndex == size){
            throw IllegalArgumentException("Array is full")
        }
        numbers[lastIndex] = value

        if(lastIndex === 0) {
            preComputed[lastIndex] = value;
        } else {
            preComputed[lastIndex] = preComputed[lastIndex-1] + value;
        }
        lastIndex++;
    }

    fun getSum(start: Int, end: Int): Int {
        println(numbers.contentToString())
        println(preComputed.contentToString())

        val firstIndex = if(start == 0)  0 else start -1;

        return preComputed[end] - preComputed[firstIndex]
    }

}


fun main() {

    var s = SimpleSumArray(size = 5);
    s.insert(1)
    s.insert(2)
    s.insert(3)
    s.insert(4)
    s.insert(5)

    println(s.getSum(2, 4)) // 12
    println(s.getSum(0, 1)) // 2
    println(s.getSum(3, 4)) // 9
    println(s.getSum(2, 3)) // 7

    /**
     * [1, 2, 3, 4, 5]
     * [1, 3, 6, 10, 15]
     * 12
     * [1, 2, 3, 4, 5]
     * [1, 3, 6, 10, 15]
     * 2
     * [1, 2, 3, 4, 5]
     * [1, 3, 6, 10, 15]
     * 9
     * [1, 2, 3, 4, 5]
     * [1, 3, 6, 10, 15]
     * 7
     */
}