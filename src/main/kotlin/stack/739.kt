package stack

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val ans = IntArray(temperatures.size)
    val temp = HashMap<Int, Int>()
    for (i in temperatures.size - 1 downTo 0) {
        var minDay = 999999
        for (e in temp.entries) {
            if (e.key > temperatures[i]) minDay = minOf(minDay, e.value)
        }
        ans[i] = (if (minDay != 999999) minDay else i) - i
        temp[temperatures[i]] = i
    }

    return ans
}

fun main() {
    println(dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73)).toList())
}