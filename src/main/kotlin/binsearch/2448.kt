package binsearch

fun minCost(nums: IntArray, cost: IntArray): Long {
    fun cost(v: Int): Long {
        var ans = 0L
        for (i in nums.indices) {
            ans += Math.abs(nums[i] - v).toLong() * cost[i]
        }
        return ans
    }

    var l = nums.min() ?: 0
    var r = (nums.max() ?: 0) + 1

    while (l < r - 1) {
        val c: Int = (l + r) / 2
        if (cost(c) > cost(c + 1)) {
            l = c + 1
        } else {
            r = c
        }
    }

    return minOf(cost(l), cost(r))
}

fun main() {
    println(
        minCost(
            intArrayOf(
                735103,
                366367,
                132236,
                133334,
                808160,
                113001,
                49051,
                735598,
                686615,
                665317,
                999793,
                426087,
                587000,
                649989,
                509946,
                743518
            ),
            intArrayOf(
                724182,
                447415,
                723725,
                902336,
                600863,
                287644,
                13836,
                665183,
                448859,
                917248,
                397790,
                898215,
                790754,
                320604,
                468575,
                825614
            )
        )
    )
}