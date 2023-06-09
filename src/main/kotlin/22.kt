fun generateParenthesis(n: Int): List<String> {
    val res = ArrayList<String>()
    gen(res, "", n, n)
    return res
}

fun gen(res: ArrayList<String>, cur: String, l: Int, r: Int) {
    if (l == 0 && r == 0)
        res.add(cur)
    if (l > 0) {
        gen(res, "$cur(", l - 1, r)
    }
    if (l < r) {
        gen(res, "$cur)", l, r - 1)
    }
}

fun main() {
    println(generateParenthesis(3))
}