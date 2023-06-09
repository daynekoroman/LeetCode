var t = 0
fun totalNQueens(n: Int): Int {
    put(ArrayList(), n)
    return t
}

fun put(q: ArrayList<Pair<Int, Int>>, n: Int) {
    if (q.size == n) {
        t++
        return
    }
    for (i in 0 until n) {
        if (validQ(q, q.size, i)) {
            q.add(Pair(q.size, i))
            put(q, n)
            q.removeAt(q.size - 1)
        }
    }
}

fun validQ(q: List<Pair<Int, Int>>, r: Int, c: Int): Boolean {
    for (p in q) {
        if (p.first == r) return false
        if (p.second == c) return false
        if (p.first - p.second == r - c) return false
        if (p.second + p.first == r + c) return false
    }
    return true
}


fun main() {
    val solveNQueens = solveNQueens(4)
    for (i in solveNQueens.indices) {
        println(solveNQueens[i])
    }
}

