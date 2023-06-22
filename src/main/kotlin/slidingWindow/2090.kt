package slidingWindow

fun getAverages(nums: IntArray, k: Int): IntArray {
    var l = 0
    var r = minOf(k * 2, nums.size)
    var sum = 0L
    for (i in 0 until r) {
        sum += nums[i]
    }

    val res = IntArray(nums.size)
    for (i in nums.indices) {
        if (i < k || i > nums.size - 1 - k) {
            res[i] = -1
            continue
        }
        sum += nums[r]
        res[i] = (sum / (r - l + 1)).toInt()
        sum -= nums[l]
        l ++
        r ++
    }
    return res
}

fun main() {
    println(getAverages(intArrayOf(7, 4, 3, 9, 1, 8, 5, 2, 6), 3).asList());
}