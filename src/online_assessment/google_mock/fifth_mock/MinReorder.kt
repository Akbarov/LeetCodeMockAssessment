package online_assessment.google_mock.fifth_mock

import java.util.*

fun main() {

}

fun minReorder(n: Int, connections: Array<IntArray>): Int {
    val graph = Array(n){mutableListOf<Pair<Int,Boolean>>()}
    for(point in connections){
        graph[point[0]].add(Pair(point[1],true))
        graph[point[1]].add(Pair(point[0],false))
    }
    val q: Queue<Int> = LinkedList()
    q.add(0)
    val set = mutableSetOf<Int>()
    var result = 0
    while(q.isNotEmpty()){
        val cur = q.poll()
        set.add(cur)
        val list = graph[cur]
        for(nextPoint in list){
            if(nextPoint.first !in set){
                if(!nextPoint.second)result++
                q.add(nextPoint.first)
            }
        }
    }
    return result
}