package twopointers

fun maxArea(height: IntArray): Int {

    var max = 0
    var l = 0
    var r = height.size - 1
    while (l < r) {
        max = maxOf(max, (r - l) * minOf(height[r], height[l]))
        if (height[l] > height[r])
            r--
        else
            l++
    }
    return max
}