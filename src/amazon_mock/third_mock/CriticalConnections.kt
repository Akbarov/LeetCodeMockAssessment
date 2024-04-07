package amazon_mock.third_mock

fun main() {

}

private fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
    val graph = createGraph(n, connections)
    return emptyList()
}

private fun createGraph(n: Int, connections: List<List<Int>>): Array<MutableList<Int>> {
    val result = Array(n) { mutableListOf<Int>() }
    for (edge in connections) {
        result[edge[0]].add(edge[1])
        result[edge[1]].add(edge[0])
    }
    return result
}