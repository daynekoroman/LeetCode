package algo

fun equalPairs(grid: Array<IntArray>): Int {
    val hashSet = HashMap<Long, Int>()
    val mod = 1e9.toLong() + 7
    for (i in grid.indices) {
        var h = 1L
        for (j in grid[i].indices) {
            h = (242 * h + grid[i][j]) % mod
        }
        hashSet[h] = (hashSet[h] ?: 0) + 1
    }
    var ans = 0
    for (i in grid.indices) {
        var h = 1L
        for (j in grid[i].indices) {
            h = (242 * h + grid[j][i]) % mod
        }
        if (hashSet.contains(h)) ans += hashSet[h]!!
    }
    return ans
}

fun main() {
    println(
        equalPairs(
            arrayOf(
                intArrayOf(2, 1),
                intArrayOf(3, 32),
            )
        )
    )
}