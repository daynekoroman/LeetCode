package contests.june10of2023

fun isFascinating(n: Int): Boolean {
    val s : String = n.toString() + (n * 2).toString() + (n * 3).toString()
    for (i in 1..9) {
        var sum = 0
        for (j in s.indices) {
            if (i.toString() == s[j].toString()) {
                sum ++
            }
        }
        if (sum != 1) return false
    }
    return true
}

fun main() {
    println(isFascinating(192))
}