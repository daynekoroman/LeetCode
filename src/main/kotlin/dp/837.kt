package dp

fun new21Game(n: Int, k: Int, maxPts: Int): Double {
    if (n - k + 1 > maxPts) return 1.0

    val prob = IntArray(k + maxPts )
    prob[0] = 1
    for (i in 0 until k) {
        for (j in 1..maxPts) {
            prob[i + j] += prob[i]
        }
    }
    var sum = 0
    var belN = 0
    for (i in k until k + maxPts) {
        sum += prob[i]
        if (i <= n)
            belN += prob[i]
    }

    return belN.toDouble() / sum
}

fun main(args: Array<String>) {
    println(new21Game(6, 1, 10))
}