package amazon_mock.eightth_mock


fun main() {

}

fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val array = mutableListOf<IntArray>()
    for (p in points) {
        array.add(intArrayOf(p.first() * p.first() + p.last() * p.last(), p.first(), p.last()))
    }
    array.sortBy { it[0] }
    val distance = array[k][0]

    val list = mutableListOf<IntArray>()
    for (item in array) {
        if (item[0] == distance) {
            list.add(intArrayOf(item[1], item[2]))
        } else if (item[0] > distance) break
    }
    return list.toTypedArray()
}
