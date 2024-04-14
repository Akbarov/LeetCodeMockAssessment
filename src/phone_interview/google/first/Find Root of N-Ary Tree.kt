package phone_interview.google.first

import Node


fun main() {

}

private fun findRoot(tree: List<Node>): Node? {
    val head: Node? = null
    var temp = 0
    for (item in tree) {
        temp = item.`val` xor temp
        for (child in item.children) {
            child?.`val`?.apply {
                temp = this xor temp
            }
        }
    }
    for (item in tree) {
        if (temp == item.`val`) return item
    }
    return head
}