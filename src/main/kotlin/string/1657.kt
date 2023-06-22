package string

fun closeStrings(word1: String, word2: String): Boolean {
    val m1 = HashMap<Char, Int>()
    val m2 = HashMap<Char, Int>()
    if (word1.length != word2.length) return false

    for (i in word1.indices) {
        m1[word1[i]] = m1.getOrDefault(word1[i], 0) + 1
        m2[word2[i]] = m2.getOrDefault(word2[i], 0) + 1
    }

    if (m1.keys != m2.keys) return false
    return m1.values.sorted() == m2.values.sorted()
}

fun main() {
    println(closeStrings("abc","bca"))
}