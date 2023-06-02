
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val count = nums.toList().groupingBy { it }.eachCount()

    val counts = count.values.toIntArray()
    val kValue = select(counts, k - 1, 0, counts.size - 1)
    val result = IntArray(k)
    var ind = 0
    for (i in count.keys) {
        if (count[i]!! > kValue)
            result[ind++] = i
    }
    if (ind < k)
    for (i in count.keys) {
        if (count[i]!! == kValue)
            result[ind++] = i
        if (ind == k) break
    }
    return result
}

fun select(counts: IntArray, k: Int, l: Int, r: Int): Int {
    var i = l
    var j = r
    val med = counts[l + (r - l) / 2]
    while(i <= j) {
        while (counts[i] > med) i++
        while (counts[j] < med) j--
        if (i <= j) {
            val t = counts[i]
            counts[i] = counts[j]
            counts[j] = t
            i++
            j--
        }
    }
    if (r - l <= 1)
        return counts[k]
    if (k <= j) return select(counts, k, l, j)
    else return select(counts, k, i, r)

}

fun main() {
//    val counts = intArrayOf(1,1,1,1, 4, 3, 2, 5, 1)

//    println(select(counts, 1, 0, counts.size - 1))
    println(topKFrequent(intArrayOf(1,1,1,2,2,3), 1).toList())
}