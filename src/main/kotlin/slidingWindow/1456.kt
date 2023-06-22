package slidingWindow

fun maxVowels(s: String, k: Int): Int {
    var t = 0
    val vowel = setOf<Char>('a', 'e', 'i', 'o', 'u')
    for (i in 0 until k)
        if (s[i] in vowel) t++
    var max = t
    for (i in k..s.length) {
        if (s[i - k] in vowel) t--
        if (s[i] in vowel) t++
        max = maxOf(max, t)
    }
    return max
}