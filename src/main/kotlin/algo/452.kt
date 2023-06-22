package algo

fun findMinArrowShots(points: Array<IntArray>): Int {
    val d = ArrayList<Pair<Pair<Int, Int>,Int>>()
    for (i in points.indices) {
        d.add(Pair(Pair(points[i][0], i), 0))
        d.add(Pair(Pair(points[i][1], i), 1))
    }
    d.sortWith(compareBy({ it.first.first }, { it.second }))
    var l = HashSet<Int>()
    var cl = HashSet<Int>()
    var ans = 0
    for (p in d) {
        if (!cl.contains(p.first.second)) {
            if (!l.contains(p.first.second)) {
               l.add(p.first.second)
            } else {
                cl.addAll(l)
                ans++
            }
        }
    }
    return ans
}


fun main() {
    println(findMinArrowShots(arrayOf(intArrayOf(10, 16), intArrayOf(2, 8), intArrayOf(7, 12), intArrayOf(1, 6))))
}
