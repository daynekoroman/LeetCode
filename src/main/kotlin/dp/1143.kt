package dp

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val dp = Array(text1.length) { IntArray(text2.length) }
    for (i in text1.indices) {
        for (j in text2.indices) {
            var max = 0
            if (i > 0) max = dp[i - 1][j]
            if (j > 0) max = Math.max(max, dp[i][j - 1])
            if (text1[i] == text2[j]) max = Math.max(max, 1 + if (i > 0 && j > 0) dp[i - 1][j - 1] else 0)
            dp[i][j] = max
        }
    }
    return dp[text1.length - 1][text2.length - 1]
}

fun main() {
    println(longestCommonSubsequence("def", "def"))
}