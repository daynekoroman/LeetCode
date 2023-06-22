package prefixTree

fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    val root = PNode(' ', null)
    words.forEach { s -> root.add(s, 0) }
    val res = HashSet<String>()
    val visited = Array<BooleanArray>(board.size) { BooleanArray(board[0].size) }
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (root.c(board[i][j]) != null)
                dfs(i, j, visited, board, root.c(board[i][j])!!, res)
        }
    }

    return res.toList()
}

val delta = arrayOf(intArrayOf(-1, 1, 0, 0), intArrayOf(0, 0, -1, 1))

fun dfs(i: Int, j: Int, visited: Array<BooleanArray>, board: Array<CharArray>, n: PNode, res: HashSet<String>) {
    if (n.str != null) res.add(n.str!!)
    for(di in 0..3) {
        val x = i + delta[0][di]
        val y = j + delta[1][di]
        if (x < 0 || x >= board.size) continue
        if (y < 0 || y >= board[0].size) continue
        if (visited[x][y]) continue
        if (n.c(board[x][y]) != null) {
            visited[i][j] = true
            dfs(x, y, visited, board, n.c(board[x][y])!!, res)
            visited[i][j] = false
        }
    }
}

//class PNode(val c: Char, var str: String?) {
//    private val ch: HashMap<Char, PNode> = HashMap()
//
//    fun add(s: String, i: Int) {
//        if (!ch.containsKey(s[i])) ch[s[i]] = PNode(s[i], null)
//        if (ch[s[i]]?.str == null && i == s.length - 1) ch[s[i]]?.str = s
//        if (i < s.length - 1) ch[s[i]]?.add(s, i + 1)
//    }
//
//    fun c(char: Char): PNode? {
//        return ch[char]
//    }
//}

fun main() {
    val m = arrayOf(
        charArrayOf('o', 'a', 'a', 'n'),
        charArrayOf('e', 't', 'a', 'e'),
        charArrayOf('i', 'h', 'k', 'r'),
        charArrayOf('i', 'f', 'l', 'v'),
    )
    println(findWords(m, arrayOf("oath", "pea", "eat", "rain")))
}