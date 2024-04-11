package amazon_mock.tenth_mock
/**
 * Prison Cells After N Days
 * There are 8 prison cells in a row and each cell is either occupied or vacant.
 *
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 *
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.
 *
 * You are given an integer array cells where cells[i] == 1 if the ith cell is occupied and cells[i] == 0
 * if the ith cell is vacant, and you are given an integer n.
 *
 * Return the state of the prison after n days (i.e., n such changes described above).
 *
 *
 *
 * Example 1:
 *
 * Input: cells = [0,1,0,1,1,0,0,1], n = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation: The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 * Example 2:
 *
 * Input: cells = [1,0,0,1,0,0,1,0], n = 1000000000
 * Output: [0,0,1,1,1,1,1,0]
 * */
fun main() {
    println(prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 7).joinToString())
    println(prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 1000000000).joinToString())

}

private fun prisonAfterNDays(cells: IntArray, n: Int): IntArray {

    val list = mutableListOf<IntArray>()
    var repeat = 0
    for (j in 0..<n) {
        var prev = 0
        for (i in 0..<8) {
            if (i == 0 || i == 7) {
                prev = cells[0]
                cells[i] = 0
            } else {
                if (prev == cells[i + 1]) {
                    prev = cells[i]
                    cells[i] = 1
                } else {
                    prev = cells[i]
                    cells[i] = 0
                }
            }

        }
        if (list.isNotEmpty() && list[0].contentEquals(cells)) {
            break
        }
        list.add(cells.copyOf())
        repeat++
    }
    return list[(n - 1) % repeat]
}