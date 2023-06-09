fun minFlips(a: Int, b: Int, c: Int): Int {
    var ab = Integer.toBinaryString(a)
    var bb = Integer.toBinaryString(b)
    var cb = Integer.toBinaryString(c)
    val maxLen = Math.max(ab.length, Math.max(bb.length, cb.length))
    ab = "0".repeat(maxLen - ab.length) + ab
    bb = "0".repeat(maxLen - bb.length) + bb
    cb = "0".repeat(maxLen - cb.length) + cb
    var res = 0
    for (i in 0 until maxLen)
        if (cb[i] == '0') {
            if (ab[i] == '1') res++
            if (bb[i] == '1') res++
        } else
            if (ab[i] == '0' && bb[i] == '0') res ++

    return res
}

fun main() {
    println(minFlips (2, 6, 5))
}

