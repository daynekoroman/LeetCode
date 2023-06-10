package algo

fun canMakeArithmeticProgression(arr: IntArray): Boolean {
    arr.sort()
    val k = arr[1] - arr[0]
    for (i in 2 until arr.size)
        if (arr[i] - arr[i - 1] != k) return false
    return true
}

fun main() {
    println(canMakeArithmeticProgression(intArrayOf(3,5,1)))
}