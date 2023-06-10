package dp

fun uniquePaths(n: Int, m: Int): Int {
    val dp = Array(n) { IntArray(m) }
    for (i in dp.indices)
        dp[i][0] = 1
    for (i in dp[0].indices)
        dp[0][i] = 1
    for (i in 1 until n) {
        for (j in 1 until m) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }
    return dp[n - 1][m - 1]
}