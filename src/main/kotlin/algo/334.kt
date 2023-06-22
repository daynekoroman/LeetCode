package algo

fun increasingTriplet(nums: IntArray): Boolean {
    val vals = ArrayList<Int>().also { it.add(nums[0]) }

    for (i in 1..nums.lastIndex) {
        when {
            nums[i] > vals.last() -> vals.add(nums[i])
            nums[i] < vals.first() -> vals[0] = nums[i]
            nums[i] > vals.first() && nums[i] < vals.last() -> vals[1] = nums[i]
        }

        if (vals.size == 3) return true
    }
    return false
}

fun main() {
    println(increasingTriplet(intArrayOf(4,6,3,4,5)))
}