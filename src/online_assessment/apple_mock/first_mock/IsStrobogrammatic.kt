package online_assessment.apple_mock.first_mock
/**
 * Given a string num which represents an integer, return true if num is a strobogrammatic number.
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 *
 *
 * Example 1:
 *
 * Input: num = "69"
 * Output: true
 * Example 2:
 *
 * Input: num = "88"
 * Output: true
 * Example 3:
 *
 * Input: num = "962"
 * Output: false
 * */
fun main() {
    println(isStrobogrammatic("0"))
    println(isStrobogrammatic("1961"))
}

private fun isStrobogrammatic(num: String): Boolean {
    var left = 0
    var right = num.lastIndex
    val set = mutableSetOf('1', '8', '0')
    while (left <= right) {
        if (num[left] in set && num[left] == num[right]) {
        } else if ((num[left] == '6' && num[right] == '9') || num[left] == '9' && num[right] == '6') {
            if (left == right) return false
        }else return false
        left++
        right--
    }
    return true
}