package online_assessment.amazon_mock.seventh_mock

import java.util.PriorityQueue

fun main() {

}

private fun arrayRankTransform(arr: IntArray): IntArray {
    val map = mutableMapOf<Int, MutableSet<Int>>()
    val pq = PriorityQueue<Int>()
    val set = mutableSetOf<Int>()
    for ((i, item) in arr.withIndex()) {
        if (map[item] == null) map[item] = mutableSetOf()
        map[item]?.add(i)
        if (item !in set) {
            set.add(item)
            pq.add(item)
        }
    }
    var level = 1
    while (pq.isNotEmpty()) {
        val item = pq.poll()
        val list = map[item] ?: emptySet()
        for (index in list) {
            arr[index] = level
        }
        level++
    }
    return arr
}