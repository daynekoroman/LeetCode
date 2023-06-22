package dp


fun makeArrayIncreasing(arr1: IntArray, arr2: IntArray): Int {
    var dp = HashMap<Int, Int>()
    arr2.sort()
    dp[-1] = 0
    for (i in arr1.indices) {
        val newDp = HashMap<Int, Int>()
        for (prev in dp.keys) {
            if (arr1[i] > prev) {
                newDp[arr1[i]] = minOf(newDp.getOrDefault(arr1[i], Int.MAX_VALUE), dp[prev]!!)
            }
            val ind = select(arr2, prev)
            if (ind < arr2.size) {
                newDp[arr2[ind]] = minOf(newDp.getOrDefault(arr2[ind], Int.MAX_VALUE), 1 + dp[prev]!!)
            }
        }
        dp = newDp
    }
    val ans: Int? = dp.values.min()
    return if (ans == null || ans == Int.MAX_VALUE) -1 else ans!!
}

private fun select(arr: IntArray, value: Int): Int {
    var l = 0
    var r = arr.size
    while (l < r) {
        val mid = (l + r) / 2
        if (arr[mid] <= value) {
            l = mid + 1
        } else {
            r = mid
        }
    }
    return l
}