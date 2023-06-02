fun trap(height: IntArray): Int {
    var sum = 0
    val lmax = IntArray(height.size)
    val rmax = IntArray(height.size)
    for (i in height.indices) lmax[i] = if (i == 0) height[i] else lmax[i - 1].coerceAtLeast(height[i])
    for (i in height.size - 1 downTo 0) rmax[i] = if (i == height.size - 1) height[i] else rmax[i + 1].coerceAtLeast(height[i])

    for (i in height.indices)
        if (lmax[i] >= height[i] && rmax[i] >= height[i])
            sum += lmax[i].coerceAtMost(rmax[i]) - height[i]
    return sum
}

fun main() {
    println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
}