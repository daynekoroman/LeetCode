package dfs

fun countPaths(grid: Array<IntArray>): Int {

    val cache = HashMap<Pair<Int, Int>, Int>()
    val mod = 1e9.toInt() + 7

    val delta = arrayOf(intArrayOf(0, 0, 1, -1), intArrayOf(1, -1, 0, 0))
    fun calc(p: Pair<Int, Int>): Int {
        if (cache.containsKey(p)) return cache[p]!!
        var res = 1

        for (i in 0..3) {
            val x = p.first + delta[0][i]
            val y = p.second + delta[1][i]
            if (x < 0 || x >= grid.size) continue
            if (y < 0 || y >= grid[0].size) continue
            if (grid[x][y] < grid[p.first][p.second])
                res = (res + calc(Pair(x, y))) % mod
        }
        cache[p] = res
        return res
    }

    var ans = 0L
    for (i in grid.indices)
        for (j in grid[0].indices) {
            ans += calc(Pair(i,j))
            ans %= mod
        }

    return ans.toInt()
}

fun main() {
    print(countPaths(arrayOf(intArrayOf(1,1), intArrayOf(3,4))))
}

