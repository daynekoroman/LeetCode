package algo

fun candy(ratings: IntArray): Int {
    val l = IntArray(ratings.size)
    for(i in l.indices)
        l[i] = if (i == 0 || ratings[i - 1] >= ratings[i]) 1 else l[i - 1] + 1
    var r = 1
    var result = 0
    for(i in l.size - 1 downTo 0) {
        r = if (i == l.size - 1 || ratings[i + 1] >= ratings[i]) 1 else r + 1
        result += Math.max(r, l[i])
    }
    return result
}

fun main() {
    println(candy(intArrayOf(1,2,2)))
}