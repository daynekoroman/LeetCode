package lines

fun maxPoints(points: Array<IntArray>): Int {
    if (points.size == 1) return 1
    var max = 0
    for (i in points.indices) {
        val visited = HashMap<Pair<Double, Double>, Int>()
        for (j in points.indices) {
            if (i == j) continue
            val k = (points[j][1] - points[i][1]).toDouble() / (points[j][0] - points[i][0])
            val b = points[i][1] - k * points[i][0]
            val p = Pair(k, b)
            if (!visited.containsKey(p)) {
                visited[p] = 1
            } else {
                visited[p] = visited[p]!! + 1
            }
            max = visited[p]?.let { maxOf(it + 1, max) }!!
        }
    }

    return max
}

fun main() {
    val input = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(3, 2),
        intArrayOf(5, 3),
        intArrayOf(4, 1),
        intArrayOf(2, 3),
        intArrayOf(1, 4),
    )
    println(maxPoints(input))
}