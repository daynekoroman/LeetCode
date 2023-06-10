package dp

fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
    val p = IntArray(Math.max(target + 1, k + 1))
    val base = 1e9.toInt() + 7
    for (t in 1..n) {
        if (n > target) break
        if (t == 1) {
            for (i in 1 ..  k) {
                p[i] = 1
            }
        } else {
            for (i in (k * t).coerceAtMost(target) downTo t) {
                var sum = 0
                for (j in i - 1 downTo Math.max(t - 1, i - k)) {
                    sum = (sum + p[j]) % base
                }
                p[i] = sum % base
            }
        }
    }

    return p[target]
}

fun main() {
    println(numRollsToTarget(30, 30, 500))
//    0 1 1 1 1 1 1
//    0 1 1 2
}