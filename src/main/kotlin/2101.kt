fun maximumDetonation(bombs: Array<IntArray>): Int {
    var max = 0
    val visited = BooleanArray(bombs.size)
    for (i in bombs.indices) {
        visited.fill(false)
        visited[i] = true
        max = Math.max(max, detonate(bombs, visited, i))
    }
    return max
}

fun detonate(bombs: Array<IntArray>, visited: BooleanArray, i: Int): Int {
    var res = 1
    for (j in bombs.indices) {
        if (!visited[j] && dist(bombs[i], bombs[j]) <= bombs[i][2]) {
            visited[j] = true
            res += detonate(bombs, visited, j)
        }
    }
    return res
}

fun dist(b1: IntArray, b2:IntArray) : Double {
    return Math.sqrt((b1[0].toDouble() - b2[0]) * (b1[0] - b2[0]) + (b1[1] - b2[1]) * (b1[1] - b2[1]))
}

fun main() {
    val bombs = arrayOf(
        intArrayOf(1,1,100000),
        intArrayOf(100000,100000,1),
//        intArrayOf( 3,4,2),
//        intArrayOf( 4,5,3),
//        intArrayOf( 5,6,4)
    )
    println( maximumDetonation(bombs))
}