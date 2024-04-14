package online_assessment.facebook_mock.third_mock

import kotlin.math.max
/**
 * Given an integer array nums and an integer k, return the maximum length of a
 * subarray
 *  that sums to k. If there is not one, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,-1,5,-2,3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * Example 2:
 *
 * Input: nums = [-2,-1,2,1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 105
 * -104 <= nums[i] <= 104
 * -109 <= k <= 109
 * */
fun main() {

}

private fun maxSubArrayLen(nums: IntArray, k: Int): Int {
    var result = 0
    val map = mutableMapOf<Int, Int>()
    var sum = 0
    for ((i, item) in nums.withIndex()) {
        sum += item
        if (map[sum] == null){
            map[sum] = i
        }
        map[sum - k]?.apply {
            result = max(result, i - this)
        }
    }

    return result
}