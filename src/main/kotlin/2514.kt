import java.math.BigInteger

fun countAnagrams(str: String): Int {
    val split = str.split(" ")
    var res = BigInteger.valueOf(1L)
    val base = BigInteger.valueOf(1e9.toLong() + 7)
    for (s in split) {
        res = res.multiply(fact(s.length, base))
        val t: HashMap<Char, Int> = HashMap()
        s.forEach { c -> t[c] = t.getOrDefault(c, 0) + 1 }
        t.values.forEach { v -> res = res * fact(v, base).modInverse(base) % base }
    }
    return res.toInt()
}

fun fact(number: Int, base: BigInteger): BigInteger {
    var result: BigInteger =  BigInteger.valueOf(1L)
    for (factor in 2..number) {
        result *=  BigInteger.valueOf(factor.toLong())
        result %= base
    }
    return result
}

fun main() {
    println(countAnagrams("b okzojaporykbmq tybq zrztwlolvcyumcsq jjuowpp"))
}