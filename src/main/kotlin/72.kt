fun minDistance(word1: String, word2: String): Int {
    if (word1.isBlank() || word2.isBlank()) return word1.length + word2.length
    val dp = Array(word2.length + 1) { IntArray(word1.length + 1) }

    for (i in dp.indices) {
        for (j in dp[i].indices) {
            if (i == 0 || j == 0) dp[i][j] = i + j
            else {
                if (word1[j - 1] == word2[i - 1])
                    dp[i][j] = dp[i - 1][j - 1]
                else {
                    var m = dp[i - 1][j]
                    m = minOf(m, dp[i][j - 1])
                    m = minOf(m, dp[i - 1][j - 1])
                    dp[i][j] = m + 1
                }
            }
        }
    }
    return dp[word2.length][word1.length];
}

fun main() {
    println(minDistance("a", "b"))
}