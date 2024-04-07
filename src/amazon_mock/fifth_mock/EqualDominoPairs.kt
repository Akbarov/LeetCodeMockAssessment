package amazon_mock.fifth_mock
/**
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d]
 * if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.
 *
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
 *
 *
 *
 * Example 1:
 *
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 * Example 2:
 *
 * Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= dominoes.length <= 4 * 104
 * dominoes[i].length == 2
 * 1 <= dominoes[i][j] <= 9
 *
 * */

fun main() {

}

private fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
    val map = mutableMapOf<Domino, Int>()
    for (d in dominoes) {
        val myDomino = Domino(d.first(), d.last())
        map[myDomino] = (map[myDomino] ?: 0) + 1
    }
    var result = 0
    for (size in map.values) {
        result+=(size*(size-1)/2)
    }
    return result
}

private class Domino(val x: Int, val y: Int) {
    override fun hashCode(): Int {
        return x.hashCode() + y.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Domino) return false
        return x == other.x && y == other.y || x == other.y && y == other.x
    }
}