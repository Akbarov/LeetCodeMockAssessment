package amazon_mock.sixth_mock

import java.util.LinkedList
import java.util.Queue
import java.util.TreeSet


fun main() {

}

private fun generateSentences(synonyms: List<List<String>>, text: String): List<String> {
    val map = mutableMapOf<String, MutableList<String>>()
    for (pair in synonyms) {
        if (map[pair.first()] == null) {
            map[pair.first()] = mutableListOf()
        }
        map[pair.first()]?.add(pair.last())
        if (map[pair.last()] == null) {
            map[pair.last()] = mutableListOf()
        }
        map[pair.last()]?.add(pair.first())
    }
    val resultList = TreeSet<String>()
    val queue: Queue<String> = LinkedList()
    queue.add(text)
    while (queue.isNotEmpty()) {
        val outPut = queue.poll()
        resultList.add(outPut)
        val words = outPut.split(" ").toMutableList()
        for ((i, w) in words.withIndex()) {
            map[w]?.let { list ->
                for (syn in list) {
                    words[i] = syn
                    val updatedString = words.joinToString(" ")
                    if (updatedString !in resultList) {
                        queue.add(updatedString)
                    }
                }
            }
        }
    }
    return resultList.toList()
}