package binsearch

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    fun time(spd: Int): Long = piles.sumOf { p -> (if (p % spd == 0) p / spd else p / spd + 1).toLong() }

    var l = 0
    var r = piles.max()

    while (r - l > 1)
        if (time(l + (r - l) / 2) > h) l += (r - l) / 2
        else r -= (r - l) / 2

    return r
}

fun main() {
    println(minEatingSpeed(intArrayOf(805306368, 805306368, 805306368), 1000000000))
}