package bfs

import java.util.*

fun isEscapePossible(blocked: Array<IntArray>, source: IntArray, target: IntArray): Boolean {
    val bl = blocked.map { Pair(it[0], it[1]) }.toSet()
    val p1 = Pair(source[0], source[1])
    val p2 = Pair(target[0], target[1])
    return bfsLimit(bl, p1, p2) && bfsLimit(bl, p2, p1)
}

val delta = arrayOf(intArrayOf(0, 0, 1, -1), intArrayOf(-1, 1, 0, 0))
fun bfsLimit(bl: Set<Pair<Int, Int>>, from: Pair<Int, Int>, to: Pair<Int, Int>): Boolean {
    val visited = HashMap<Pair<Int, Int>, Int>()
    visited[from] = 0
    val q = LinkedList<Pair<Int, Int>>()
    q.add(from)
    while (!q.isEmpty()) {
        val p = q.poll()
        for (i in 0..3) {
            val x = p.first + delta[0][i]
            val y = p.second + delta[1][i]
            if (x < 0 || x >= 1e6) continue
            if (y < 0 || y >= 1e6) continue
            val pair = Pair(x, y)
            if (bl.contains(pair) || visited.containsKey(pair)) continue
            visited[pair] = visited[p]!! + 1
            q.add(pair)
            if (visited[pair]!! > 200 || pair == to)
                return true
        }
    }

    return false
}

fun main() {
    println(isEscapePossible(Array<IntArray>(0) { IntArray(0) }, intArrayOf(0, 0), intArrayOf(99999, 99999)))
}

