package dfs

fun longestIncreasingPath(grid: Array<IntArray>): Int {

    val cache = HashMap<Pair<Int, Int>, Int>()

    val delta = arrayOf(intArrayOf(0, 0, 1, -1), intArrayOf(1, -1, 0, 0))
    fun calc(p: Pair<Int, Int>): Int {
        if (cache.containsKey(p)) return cache[p]!!
        var res = 0

        for (i in 0..3) {
            val x = p.first + delta[0][i]
            val y = p.second + delta[1][i]
            if (x < 0 || x >= grid.size) continue
            if (y < 0 || y >= grid[0].size) continue
            if (grid[x][y] > grid[p.first][p.second])
                res = maxOf(res, calc(Pair(x, y)))
        }
        cache[p] = res + 1
        return res + 1
    }

    var ans = 0
    for (i in grid.indices)
        for (j in grid[0].indices) {
            ans = maxOf(ans, calc(Pair(i,j)))
        }

    return ans
}

fun main() {
    println(longestIncreasingPath(arrayOf(intArrayOf(9,9,4), intArrayOf(6,6,8), intArrayOf(2,2,1))))
}