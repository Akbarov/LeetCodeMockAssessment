package online_assessment.amazon_mock.eightth_mock


fun main() {

}

private fun longestPalindrome(s: String): String {
    var result = ""
    for (i in 1..<s.lastIndex) {
        var current = getPalindromeLength(s, i, i)
        if (current.length > result.length) result = current
        current = getPalindromeLength(s, i - 1, i)
        if (current.length > result.length) result = current
    }
    return result
}

private fun getPalindromeLength(s: String, left: Int, right: Int): String {
    var l = left
    var r = right
    while (l >= 0 && r < s.length) {
        if (s[l] != s[r]) {
            break
        }
        l--
        r++
    }
    return s.substring(l + 1, r)
}