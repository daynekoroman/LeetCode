package twopointers

fun maxOperations(nums: IntArray, k: Int): Int {
    val m = HashMap<Int, Int>()
    nums.forEach { n ->
        m.putIfAbsent(n, 0)
        m[n] = m[n]!! + 1
    }
    var ans = 0
    for (n in nums) {
        if (m.containsKey(k - n) && (n != k - n && m[k - n]!! > 0 && m[n]!! > 0 || n == k - n && m[n]!! > 1)) {
            ans ++
            m[n] = m[n]!! - 1
            m[k - n] = m[k - n]!! - 1
        }
    }
    return ans
}