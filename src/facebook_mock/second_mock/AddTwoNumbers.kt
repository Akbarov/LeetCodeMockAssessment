package facebook_mock.second_mock

import ListNode

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * */

fun main() {

}

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val result = ListNode(0)
    var temp: ListNode? = result
    var list1 = l1
    var list2 = l2
    var over = 0
    while (list1 != null || list2 != null) {
        over += list1?.`val` ?: 0
        over += list2?.`val` ?: 0
        temp?.next = ListNode(over % 10)
        over /= 10
        temp = temp?.next
        list1 = list1?.next
        list2 = list2?.next

    }
    if (over > 0) {
        temp?.next = ListNode(over)
    }
    return result.next
}