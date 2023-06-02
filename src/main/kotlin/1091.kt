fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    val q = ArrayDeque<Pair<Int,Int>>()
    if (grid[0][0] == 1) return -1
    if (0 == grid.size - 1 && 0 == grid[0].size - 1) return 1
    q.add(Pair(0,0))
    while (!q.isEmpty()) {
        val p = q.removeFirst()
        for (i in -1..1)
            for(j in -1 .. 1) {
                if (i == 0 && j == 0) continue
                val x = p.first + i
                val y = p.second + j
                if (x < 0 || x >= grid.size) continue
                if (y < 0 || y >= grid[0].size) continue
                if (grid[x][y] != 0) continue
                grid[x][y] = grid[p.first][p.second] - 1
                if (x == grid.size - 1 && y == grid[0].size - 1) return Math.abs(grid[x][y] - 1)
                q.add(Pair(x,y))
            }
    }

    return -1
}

fun main() {
    println(shortestPathBinaryMatrix(arrayOf(intArrayOf(0))))
}