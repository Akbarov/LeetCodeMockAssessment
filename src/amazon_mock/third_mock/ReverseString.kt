package amazon_mock.third_mock

import kotlin.math.min

/**
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Example 2:
 *
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 *
 * */
fun main() {
    println(
        reverseStr(
            "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl",
            39
        )
    )
    println(reverseStr("abcdfeg", 4))
}

private fun reverseStr(s: String, k: Int): String {
    val charArray = s.toCharArray()

    if (k <= 1) return s
    if (k >= s.length) return s.reversed()
    var endIndex = k - 1
    var startIndex = 0
    while (startIndex < s.length) {
        reverseSubString(charArray, startIndex, endIndex)
        startIndex += (2 * k)
        endIndex = min(endIndex + 2 * k, s.lastIndex)
    }
    return charArray.joinToString("")

}

private fun reverseSubString(charArray: CharArray, start: Int, end: Int) {
    var s = start
    var e = end
    while (s < e) {
        charArray[s] = charArray[e].also { charArray[e] = charArray[s] }
        s++
        e--
    }
}