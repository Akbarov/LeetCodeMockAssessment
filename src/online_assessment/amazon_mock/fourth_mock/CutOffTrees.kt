package online_assessment.amazon_mock.fourth_mock

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue


fun main() {

}

private fun cutOffTree(forest: List<List<Int>>): Int {
    val matrix = forest.map { it.toIntArray() }.toTypedArray()
    val pq = PriorityQueue<Tree> { o1, o2 -> o1.height.compareTo(o2.height) }
    var pathWayLength = 0
    var prevPoint = Pair(0, 0)
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            pq.add(Tree(i, j, matrix[i][j]))
        }
    }
    while (pq.isNotEmpty()) {
        val tree = pq.poll()
        val length = getLengthPathWayTwoPoint(Pair(tree.row, tree.cal), prevPoint, matrix)
        if (length == -1) return -1
        pathWayLength += length
        prevPoint = Pair(tree.row, tree.cal)
        matrix[tree.row][tree.cal] = 1

    }
    return pathWayLength
}

private fun getLengthPathWayTwoPoint(start: Pair<Int, Int>, end: Pair<Int, Int>, matrix: Array<IntArray>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val visited = Array(matrix.size) { BooleanArray(matrix[0].size) }
    queue.add(start)
    var pathLength = 0
    visited[start.first][start.second] = true
    val edg = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    while (queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val cur = queue.poll()
            if (cur == end) return pathLength
            for (next in edg) {
                val row = cur.first + next.first()
                val col = cur.second + next.last()
                if (row in matrix.indices && col in matrix[0].indices && !visited[row][col] && matrix[row][col] != 0) {
                    queue.add(Pair(row, col))
                    visited[row][col] = true
                }
            }
        }
        pathLength++
    }
    return -1
}

private data class Tree(val row: Int, val cal: Int, val height: Int)