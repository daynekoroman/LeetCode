import java.util.PriorityQueue

class MedianFinder() {

    val minQ = PriorityQueue<Int> { p1, p2 -> p2 - p1 }
    val maxQ = PriorityQueue<Int>()

    fun addNum(num: Int) {
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

    fun findMedian(): Double {
        return if (minQ.size == maxQ.size) (minQ.peek() + maxQ.peek()).toDouble() / 2
        else if (minQ.size > maxQ.size) minQ.peek().toDouble()
        else maxQ.peek().toDouble()
    }

}

fun main() {
    val medianFinder = MedianFinder()
    medianFinder.addNum(5)
    medianFinder.addNum(4)
    println(medianFinder.findMedian())
    medianFinder.addNum(3)
    medianFinder.addNum(2)
    medianFinder.addNum(1)
    println(medianFinder.findMedian())
}