package heap

import java.util.*


fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val minQ = PriorityQueue<Int> { p1, p2 -> p2 - p1 }
    val maxQ = PriorityQueue<Int>()
    nums1.forEach { i -> addNum(i, minQ, maxQ) }
    nums2.forEach { i -> addNum(i, minQ, maxQ) }

    return if (minQ.size == maxQ.size) (minQ.peek() + maxQ.peek()).toDouble() / 2
    else if (minQ.size > maxQ.size) minQ.peek().toDouble()
    else maxQ.peek().toDouble()
}

fun addNum(num: Int, minQ: PriorityQueue<Int>, maxQ: PriorityQueue<Int>) {
    if (minQ.isEmpty()) { minQ.add(num); return }

    if (num >= minQ.peek())
        maxQ.add(num)
    else
        minQ.add(num)

    if (minQ.size > maxQ.size + 1) {
        maxQ.add(minQ.poll())
    }
    if (minQ.size < maxQ.size - 1) {
        minQ.add(maxQ.poll())
    }

}