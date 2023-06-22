package prefixTree

fun wordBreak(s: String, wordDict: List<String>): List<String> {
    val root = PNode(' ', null)
    wordDict.forEach { root.add(it, 0) }
    val res = HashSet<String>()

    fun dfsWordBreak(i: Int, use: ArrayList<String>, n: PNode) {
        if (i == s.length) {
            res.add(use.joinToString(" "))
            return
        }
        if (n.str != null) {
            use.add(n.str!!)
            dfsWordBreak(i + 1, use, root)
            use.removeAt(use.size - 1)
        }
        if (n.c(s[i]) != null) {
            dfsWordBreak(i + 1, use, n.c(s[i])!!)
        }
    }

    dfsWordBreak( 0, ArrayList(), root)

    return res.toList()
}

fun main() {
    println(wordBreak("catsanddog", listOf("cat","cats","and","sand","dog")))
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
