package amazon_mock.second_mock
/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 * */

fun main() {

}

private fun partitionLabels(s: String): List<Int> {
    val array = IntArray(26)
    for (c in s) {
        array[c - 'a']++
    }
    var left = -1
    val result = mutableListOf<Int>()
    val set = mutableSetOf<Char>()
    for (right in s.indices) {
        val current = s[right]
        set.add(current)
        array[current - 'a']--
        var flag = true
        if (array[current - 'a'] == 0) {
            for (item in set) {
                if (array[item - 'a'] != 0) {
                    flag = false
                }
            }
            if (flag) {
                set.clear()
                result.add(right - left)
                left = right
            }
        }

    }
    return result
}