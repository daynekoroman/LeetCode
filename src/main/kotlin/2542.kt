import java.util.PriorityQueue

fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
    val pairList = nums1.zip(nums2).sortedWith(compareBy({ -it.second }, { -it.first }))

    val backpack = PriorityQueue<Int>()
    var min = pairList[0].second
    var sum: Long = pairList[0].first.toLong()
    var res = sum * min
    backpack.add(pairList[0].first)

    for (i in 1 until k) {
        backpack.add(pairList[i].first)
        sum += pairList[i].first
        min = Math.min(min, pairList[i].second)
        res = sum * min
    }


    for (i in k until pairList.size) {
        val minValue = backpack.poll()
        backpack.add(pairList[i].first)
        sum = sum - minValue + pairList[i].first
        min = Math.min(min, pairList[i].second)
        res = Math.max(res, sum * min)
    }

    return res;
}

fun main(args: Array<String>) {
    println(maxScore(intArrayOf(1, 2, 3, 5, 4), intArrayOf(3, 3, 2, 2, 2), 2))
//    println( maxScore(intArrayOf(1,3,3,2), intArrayOf(2,1,3,4), 3))
//    println( maxScore(intArrayOf(4,2,3,1,1), intArrayOf(7,5,10,9,6), 1))
}

//2 2 2 2 5
//2 2 2 2 1
//4 4 4 4 5
//1 5
//2 8
//3 12