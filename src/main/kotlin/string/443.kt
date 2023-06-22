package string

fun compress(chars: CharArray): Int {
    val res = StringBuilder()
    var l = 0
    var c = chars[0]
    for (i in chars.indices) {
        if (c == chars[i])
            l++
        else {
            res.append(if (l == 1) c else "$c" + l)
            l = 1
            c = chars[i]
        }
    }
    res.append(if (l == 1) c else "$c" + l)
    val resS = res.toString()
    for (i in resS.indices) {
        chars[i] = resS[i]
    }
    return res.length
}


fun main() {
    println(compress(charArrayOf('a', 'b', 'c')))
}