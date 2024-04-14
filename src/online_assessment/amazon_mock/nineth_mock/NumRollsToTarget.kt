package online_assessment.amazon_mock.nineth_mock

/**
 * Number of Dice Rolls With Target Sum
 * You have n dice, and each dice has k faces numbered from 1 to k.
 *
 * Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice,
 * so the sum of the face-up numbers equals target.
 * Since the answer may be too large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1, k = 6, target = 3
 * Output: 1
 * Explanation: You throw one die with 6 faces.
 * There is only one way to get a sum of 3.
 * Example 2:
 *
 * Input: n = 2, k = 6, target = 7
 * Output: 6
 * Explanation: You throw two dice, each with 6 faces.
 * There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 * Example 3:
 *
 * Input: n = 30, k = 30, target = 500
 * Output: 222616187
 * Explanation: The answer must be returned modulo 109 + 7.
 * */
fun main() {

}

private val mod = 1_000_000_007
private fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
    val dp = Array(n + 1) { IntArray(target + 1) { -1 } }
    dfs(dp, n, k, target)
    return dp[n][target]
}

private fun dfs(dp: Array<IntArray>, n: Int, k: Int, target: Int): Int {
    if (n < 0 || target < 0) return 0
    if (n == 1) {
        dp[n][target] = if (target in 1..k) 1 else 0
        return dp[n][target]
    }
    if (dp[n][target] != -1) {
        return dp[n][target]
    }
    var count = 0
    for (face in 1..k) {
        count = (dfs(dp, n - 1, k, target - face) % mod + count % mod) % mod
    }
    dp[n][target] = count
    return dp[n][target]
}