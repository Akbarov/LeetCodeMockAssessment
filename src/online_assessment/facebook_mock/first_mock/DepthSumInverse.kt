package online_assessment.facebook_mock.first_mock

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int?

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>?
}

fun main() {

}

private fun depthSumInverse(nestedList: List<NestedInteger>): Int {
    val queue: Queue<List<NestedInteger>> = LinkedList()
    var level = 1
    var maxDepth = 1
    val list = mutableListOf<Pair<Int, Int>>()
    queue.add(nestedList)
    while (queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val currentList = queue.poll()
            for (item in currentList) {
                if (item.isInteger()) {
                    item.getInteger()?.let { value ->
                        list.add(Pair(value, level))
                        maxDepth = max(maxDepth, level)
                    }
                } else {
                    item.getList()?.apply { queue.add(this) }
                }
            }
        }
        level++
    }
    var result = 0
    for ((item, depth) in list) {
        result += (maxDepth - depth + 1) * item
    }
    return result
}
