package backtracking

fun solveNQueens(n: Int): List<List<String>> {
    val res = ArrayList<List<String>>()
    put(res, ArrayList(), n)
    return res
}

fun put(acc: ArrayList<List<String>>, q: ArrayList<Pair<Int, Int>>, n: Int) {
    if (q.size == n) {
        val s = ".".repeat(n)
        acc.add(q.map { p ->
            val chars = s.toCharArray()
            chars[p.second] = 'Q'
            String(chars)
        }.toList())
        return
    }
    for (i in 0 until n) {
        if (valid(q, q.size, i)) {
            q.add(Pair(q.size, i))
            put(acc, q, n)
            q.removeAt(q.size - 1)
        }
    }
}

fun valid(q: List<Pair<Int, Int>>, r: Int, c: Int): Boolean {
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

