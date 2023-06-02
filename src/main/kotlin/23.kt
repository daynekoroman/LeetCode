import java.util.PriorityQueue

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 *
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val q = PriorityQueue<ListNode>(compareBy { it.`val` })
    lists .filterNotNull().forEach { l -> q.add(l) }

    val head = q.poll()
    if (head?.next != null) q.add(head.next)

    var tail = head

    while (!q.isEmpty()) {
        val min = q.poll()
        if (min.next != null) q.add(min.next)
        tail.next = min
        tail = min
    }

    return head
}


fun main() {

}