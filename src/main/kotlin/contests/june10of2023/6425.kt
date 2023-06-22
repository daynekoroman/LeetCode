package contests.june10of2023

fun longestSemiRepetitiveSubstring(s: String): Int {
    if (s.length == 1) return 1
    var l = 0
    var r = 1
    var max = 2
    r ++
    var ss = if (s[0] == s[1]) 1 else 0
    var p = if (s[0] == s[1]) 1 else 0
    while (r < s.length) {
        if (s[r] == s[r - 1]) {
            ss ++
            if (ss == 2) {
                l = p
                ss --
            }
            p = r
        }
        if (max < r - l + 1) max = r - l + 1
        r++
    }
    return max
}

fun main() {
    println(longestSemiRepetitiveSubstring("1111111"))
}