package facebook_mock.fifth_mock

import kotlin.math.min

fun main() {

}

private fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
    val list = binaryMatrix.dimensions()
    val row = list.first()
    val col = list.last()
    var result = col + 1
    for (i in 0..<row) {
        var left = 0
        var current = col + 1
        var right = col - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (binaryMatrix.get(i, mid) == 0) {
                left = mid + 1
            } else {
                right = mid - 1
                current = mid
            }
        }
        result = min(result, current)
    }
    return result
}

private class BinaryMatrix {
    fun get(row: Int, col: Int): Int {
        return 0
    }

    fun dimensions(): List<Int> {
        return emptyList()
    }
}