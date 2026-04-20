import com.marceloserpa.FenwickTree
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FenwickTreeTest {
    @Test
    fun testSumFromBeginning() {
        val numbers: IntArray = intArrayOf(5,2,9,-3,5,20,10,-7,2,3,-4,0,-2,15,5)
        val fenwickTree  = FenwickTree(numbers.size)
        for(i in numbers.indices) {
            fenwickTree.putValue(i,numbers[i])
        }

        assertEquals(41, fenwickTree.sum(8))
        assertEquals(16, fenwickTree.sum(3))
        assertEquals(18, fenwickTree.sum(5))
    }

    @Test
    fun testRangeQuery() {
        val numbers: IntArray = intArrayOf(5,2,9,-3,5,20,10,-7,2,3,-4,0,-2,15,5)
        val fenwickTree  = FenwickTree(numbers.size)
        for(i in numbers.indices) {
            fenwickTree.putValue(i,numbers[i])
        }

        assertEquals(35, fenwickTree.range(4, 7))
    }

    @Test
    fun testSumFromBeginningUsingFactory() {
        val numbers: IntArray = intArrayOf(5,2,9,-3,5,20,10,-7,2,3,-4,0,-2,15,5)
        val fenwickTree  = FenwickTree.createFromValues(numbers)

        assertEquals(41, fenwickTree.sum(8))
        assertEquals(16, fenwickTree.sum(3))
        assertEquals(18, fenwickTree.sum(5))
    }

    @Test
    fun testRangeQueryUsingFactory() {
        val numbers: IntArray = intArrayOf(5,2,9,-3,5,20,10,-7,2,3,-4,0,-2,15,5)
        val fenwickTree  = FenwickTree.createFromValues(numbers)

        assertEquals(35, fenwickTree.range(4, 7))
    }
}