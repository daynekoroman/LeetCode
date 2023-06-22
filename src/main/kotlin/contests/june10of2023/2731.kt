package contests.june10of2023

fun sumDistance(nums: IntArray, s: String, d: Int): Int {
    for (i in nums.indices) {
        if (s[i] == 'R')
            nums[i] += d
        else
            nums[i] -= d
    }

    nums.sort()
    var res = 0L
    val mod = 1e9.toLong() + 7
    for (i in nums.indices) {
        res += i * nums[i].toLong() - (nums.size - 1 - i) * nums[i].toLong()
        res %= mod
    }

    return res.toInt()
}

fun main() {
    println(sumDistance(intArrayOf(-2, 0, 2), "RLL", 3))
}