package string

fun productExceptSelf(nums: IntArray): IntArray {
    val l = IntArray(nums.size)
    l[0] = nums[0]
    for (i in 1 until nums.size) {
        l[i] = nums[i] * l[i - 1]
    }
    var r = 1
    val res = IntArray(nums.size)
    for (i in nums.size - 1 downTo 1) {
        res[i] = l[i - 1] * r
        r *= nums[i]
    }
    res[0] = r
    return res
}