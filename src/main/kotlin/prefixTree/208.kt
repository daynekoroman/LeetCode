package prefixTree
class PNode(val c: Char, var str: String?) {
    private val ch: HashMap<Char, PNode> = HashMap()

    fun add(s: String, i: Int) {
        if (!ch.containsKey(s[i])) ch[s[i]] = PNode(s[i], null)
        if (ch[s[i]]?.str == null && i == s.length - 1) ch[s[i]]?.str = s
        if (i < s.length - 1) ch[s[i]]?.add(s, i + 1)
    }

    fun c(char: Char): PNode? {
        return ch[char]
    }
}

class Trie() {

    private val root = PNode(' ', null)

    fun insert(word: String) {
        root.add(word, 0)
    }

    fun search(word: String): Boolean {
        var n = root
        for (c in word) {
            if (n.c(c) == null) return false
            n = n.c(c)!!
        }
        return n.str.equals(word)
    }

    fun startsWith(prefix: String): Boolean {
        var n = root
        for (c in prefix) {
            if (n.c(c) == null) return false
            n = n.c(c)!!
        }
        return true
    }

}

