package algo

fun summaryRanges(nums: IntArray): List<String> {
    var l: Int? = null
    val result = ArrayList<String>()
    for (i in nums.indices) {
        if (l == null) {
            l = i
        } else {
            if (nums[i] > nums[i - 1] + 1) {
                if (i - 1 - l > 0) {
                    result.add("${nums[l]}->${nums[i - 1]}")
                } else {
                    result.add("${nums[l]}")
                }
                l = i
            }
        }
    }
    if (l != null) {
        if (nums.size - l > 1) {
            result.add("${nums[l]}->${nums[nums.size - 1]}")
        } else {
            result.add("${nums[l]}")
        }
    }
    return result
}

fun main() {
    println(summaryRanges(intArrayOf(0,1,2,4,5,7)))
}