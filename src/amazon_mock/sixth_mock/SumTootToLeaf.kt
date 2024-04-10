package amazon_mock.sixth_mock

import TreeNode


fun main() {

}

private var result = 0
private fun sumRootToLeaf(root: TreeNode?): Int {
    sum(root, "")
    return result
}

private fun sum(root: TreeNode?, current: String) {
    if (root == null) return
    if (root.left == null && root.right == null) {
        result += (current + root.`val`).toInt(10)
        return
    }
    sum(root.left, current + root.`val`)
    sum(root.right, current + root.`val`)
}