package online_assessment.amazon_mock.first_mock

import kotlin.math.max
import kotlin.math.min

/**
 *
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * */

fun main() {

}

private fun gcdOfStrings(str1: String, str2: String): String {
    if (str1 + str2 != str2 + str1) return ""
    if (str2.isEmpty() || str1.isEmpty()) return ""
    val a = max(str2.length, str1.length)
    val b = min(str2.length, str1.length)
    val gcd = gcd(a, b)
    return str1.substring(0, gcd)

}

private fun gcd(a: Int, b: Int): Int {
    if (b == 0) return 0
    if (a % b == 0) return b
    return gcd(b, a % b)
}