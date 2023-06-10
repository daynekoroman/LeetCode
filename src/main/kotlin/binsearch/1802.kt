package binsearch

fun maxValue(n: Int, index: Int, maxSum: Int): Int {
//    if (n == 4 && index == 0 && maxSum == 4) return 1
    var l = 0;
    var r = maxSum;
    while (l < r - 1) {
        val c = l + (r - l) / 2
        if (sum1802(c, index, n) > maxSum) {
            r = c
        } else {
            l = c
        }
    }
    return if (sum1802(r, index, n) <= maxSum) r else l
}

fun sum1802(v: Int, index: Int, n: Int): Long {
    val lIndex = if (v > index) index else v - 1
    val lOnes = index - lIndex
    val l = (2 * v - lIndex).toDouble() / 2 * (lIndex + 1) - v + lOnes
    val rIndex = if (v > n - index - 1) n - index - 1 else v - 1
    val rOnes = n - index - 1 - rIndex
    val r = (2 * v - rIndex).toDouble() / 2 * (rIndex + 1) - v + rOnes
    return (l + r + v).toLong()
}

fun main() {
    println(maxValue(4,2,6))
}