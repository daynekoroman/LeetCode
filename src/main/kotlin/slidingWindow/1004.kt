package slidingWindow

fun longestOnes(nums: IntArray, k: Int): Int {
    var n = 0;
    var max = 0;
    var l = 0

    for (r in nums.indices){
        if(nums[r] == 1) n++

        if(r - l + 1 > n + k){
            if(nums[l] == 1) n--
            l++
        }
        max = maxOf(max, r - l + 1)
    }
    return max
}

fun main() {
    println(longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2))
}

