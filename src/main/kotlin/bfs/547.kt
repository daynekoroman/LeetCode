package bfs

fun findCircleNum(isConnected: Array<IntArray>): Int {
    var color = 0
    val colors = HashMap<Int, Int>()
    for (i in isConnected.indices) {
        if (!colors.containsKey(i)) {
            color++
            val q = ArrayDeque<Int>()
            colors[i] = color
            q.add(i)
            while (!q.isEmpty()) {
                val e = q.removeFirst()
                isConnected[e].indices.filter { j -> isConnected[e][j] == 1 && !colors.containsKey(j) }.forEach { j ->
                    run {
                        q.add(j)
                        colors[j] = color
                    }
                }
            }
        }
    }
    return color
}

fun main() {
    println(findCircleNum(arrayOf(intArrayOf(1, 0, 0, 1), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 1), intArrayOf(1,0,1,1))))
}