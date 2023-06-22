package dfs


val mod = 1e9.toLong() + 7

fun numOfWays(nums: IntArray): Int {
    // Table of Pascal's triangle
    val table = Array(nums.size) { LongArray(nums.size) }
    for (i in nums.indices) {
        table[i][i] = 1
        table[i][0] = table[i][i]
    }
    for (i in 2 until nums.size) {
        for (j in 1 until i) {
            table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % mod
        }
    }
    return ((dfs(nums.toList(), table) - 1) % mod).toInt()
}

private fun dfs(nums: List<Int>, table: Array<LongArray>): Long {
    if (nums.size < 3) {
        return 1
    }
    val l: MutableList<Int> = ArrayList()
    val r: MutableList<Int> = ArrayList()
    for (i in 1 until nums.size) {
        if (nums[i] < nums[0]) {
            l.add(nums[i])
        } else {
            r.add(nums[i])
        }
    }
    val dfsl = dfs(l, table) % mod
    val dfsr = dfs(r, table) % mod
    val req = dfsl * dfsr % mod
    return (req * table[nums.size - 1][l.size]) % mod
}

fun main() {
    println(numOfWays(intArrayOf(3, 4, 5, 1, 2)))
}


