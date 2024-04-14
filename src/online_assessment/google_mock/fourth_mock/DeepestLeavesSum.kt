package online_assessment.google_mock.fourth_mock

import TreeNode
import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

fun main() {
println(deepestLeavesSum(null))
}

private fun deepestLeavesSum(root: TreeNode?): Int {
    val queue: Queue<TreeNode> = LinkedList()
    if (root == null) return 0
    var result = root.`val`
    queue.add(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        var sum = 0
        repeat(size) {
            val node = queue.poll()
            sum+=node.`val`
            node.left?.apply { queue.add(this) }
            node.right?.apply { queue.add(this) }
        }
        result = max(result,sum)
    }
    return result
}