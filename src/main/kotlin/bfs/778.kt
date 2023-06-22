package bfs

import java.util.*

fun swimInWater(grid: Array<IntArray>): Int {
    val h: HashMap<Pair<Int, Int>, Int> = HashMap()
    val q = PriorityQueue<Pair<Int, Int>> { p1, p2 -> h[p1]!! - h[p2]!! }
    val delta = arrayOf(intArrayOf(1, -1, 0, 0), intArrayOf(0, 0, -1, 1))
    val start = Pair(0, 0)
    h[start] = grid[0][0]
    q.add(start)
    val n = grid.size - 1
    while (!q.isEmpty()) {
        val cur = q.poll()
        for (i in 0..3) {
            val p = Pair(cur.first + delta[0][i], cur.second + delta[1][i])
            if (p.first == n && p.second == n) return maxOf(grid[n][n], h[cur]!!)
            if (p.first < 0 || p.first > n) continue
            if (p.second < 0 || p.second > n) continue
            if (h.containsKey(p)) continue
            h[p] = maxOf(grid[p.first][p.second], h[cur]!!)
            q.add(p)
        }
    }
    return 0
}

fun main() {
    println(
        swimInWater(
            arrayOf(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(25, 27, 99, 99, 5),
                intArrayOf(9, 8, 7, 6, 5),
                intArrayOf(9, 21, 32, 43, 54),
                intArrayOf(9, 9, 9, 9, 9)
            )
        )
    )
}