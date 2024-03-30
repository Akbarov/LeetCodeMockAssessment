package google_mock.second_mock

/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
 *
 * Choosing any x with 0 < x < n and n % x == 0.
 * Replacing the number n on the chalkboard with n - x.
 * Also, if a player cannot make a move, they lose the game.
 *
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * Example 2:
 *
 * Input: n = 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.*/
fun main() {

}

private fun divisorGame(n: Int): Boolean {
    if (n <= 1) return false
    if (n == 2) return true
    if (n == 3) return false
    val db = BooleanArray(n + 1)
    db[2] = true
    for (i in 4..n) {
        for (j in 1..<i) {
            if (i % j == 0 && !db[i - j]) db[i] = true
        }
    }
    return db[n]

}