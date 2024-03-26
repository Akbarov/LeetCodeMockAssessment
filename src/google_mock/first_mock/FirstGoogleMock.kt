package google_mock.first_mock

/**
 * You have n  tiles, where each tile has one letter tiles[i] printed on it.
 *
 * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 * Example 1:
 *
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * Example 2:
 *
 * Input: tiles = "AAABBC"
 * Output: 188
 * Example 3:
 *
 * Input: tiles = "V"
 * Output: 1
 *
 * */
fun main() {
   println(numTilePossibilities("AAB"))
   println(set)
}

private var count = 0
private val set = mutableSetOf<String>()
private fun numTilePossibilities(tiles: String): Int {
    if (tiles.length == 1) return 1
    val usedIndex = mutableSetOf<Int>()
    for (i in tiles.indices) {
        usedIndex.add(i)
        dfs(tiles, tiles[i].toString(), usedIndex)
        usedIndex.remove(i)
    }
    return count
}

private fun dfs(tiles: String, current: String, usedIndexes: MutableSet<Int>) {
    if (current in set) return
    set.add(current)
    count++
    for (i in tiles.indices) {
        if (i !in usedIndexes) {
            usedIndexes.add(i)
            dfs(tiles, current + tiles[i], usedIndexes)
            usedIndexes.remove(i)
        }
    }
}