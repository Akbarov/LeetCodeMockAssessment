package amazon_mock.seventh_mock

import TreeNode

fun main() {

}

private val set = mutableSetOf<Int>()

private fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
    firstBST(root1,target)
    return secondBST(root2)
}

private fun firstBST(root1: TreeNode?, target: Int) {
    if (root1 == null) return
    set.add(target - root1.`val`)
    firstBST(root1.left, target)
    firstBST(root1.right, target)
}

private fun secondBST(root: TreeNode?): Boolean {
    if (root == null) return false
    if (root.`val` in set) return true
    return secondBST(root.left) ||
            secondBST(root.right)
}