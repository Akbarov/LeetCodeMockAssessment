package online_assessment.facebook_mock.fourth_mock

import TreeNode
import kotlin.math.abs
/**
 * Given the root of a binary search tree and a target value,
 * return the value in the BST that is closest to the target.
 * If there are multiple answers, print the smallest.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 * Output: 4
 * Example 2:
 *
 * Input: root = [1], target = 4.428571
 * Output: 1
 *
 * */
fun main() {

}

private var result = Int.MIN_VALUE
private fun closestValue(root: TreeNode?, target: Double): Int {
    if (root == null) return -1
    result = root.`val`
    dfs(root, target)
    return result
}

private fun dfs(root: TreeNode?, target: Double) {
    if (root == null) return
    if (abs(root.`val` - target) < abs(root.`val` - result)) {
        result = root.`val`
    }
    if (abs(root.`val` - target) == abs(target - result) && root.`val` < result) {
        result = root.`val`
    }

    if (target < root.`val`) {
        dfs(root.left, target)
    } else {
        dfs(root.right, target)
    }
}