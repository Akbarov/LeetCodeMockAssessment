package online_assessment.facebook_mock.first_mock

import TreeNode


fun main() {

}

private fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    if (root == null) return 0
    if (high <= root.`val`) {
        return rangeSumBST(root.left, low, high) + if (high == root.`val`) root.`val` else 0
    }
    if (low >= root.`val`) {
        return rangeSumBST(root.right, low, high) + if (low == root.`val`) root.`val` else 0
    }
    return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + root.`val`

}