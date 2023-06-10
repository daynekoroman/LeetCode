package structures

import java.util.PriorityQueue

class SmallestInfiniteSet() {

    val s = PriorityQueue<Int>()
    val set = HashSet<Int>()

    init {
        (1..1000).forEach { set.add(it); s.add(it) }
    }

    fun popSmallest(): Int {
        val poll = s.poll()
        set.remove(poll)
        return poll
    }

    fun addBack(num: Int) {
        if (set.contains(num)) {
            s.add(num); set.add(num)
        }
    }

}

fun main() {
    val smallestInfiniteSet = SmallestInfiniteSet()
    smallestInfiniteSet.addBack(2)
    println(smallestInfiniteSet.popSmallest())
}