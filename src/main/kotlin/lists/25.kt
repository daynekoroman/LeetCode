package lists

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    var cur = head
    var prev: ListNode? = null
    var ans: ListNode? = null
    var ttail = cur
    var t = 0
    var prevTail: ListNode? = null
    while (cur != null) {
        t++
        if (t == k) {
            val next = cur.next
            val rev = reverse(ttail, cur)
            if (ans == null) ans = rev.second
            rev.first?.next = next
            if (prevTail != null) prevTail.next = rev.second
            t = 0
            prevTail = rev.first
            ttail = next
            cur = next
        } else
        cur = cur.next
    }
    return ans ?: head
}

fun reverse(head: ListNode?, tail: ListNode?): Pair<ListNode?, ListNode?> {
    var newTail = head
    var cur: ListNode? = head
    var prev: ListNode? = null
    while (tail != prev) {
        val temp = cur?.next
        cur?.next = prev
        prev = cur
        cur = temp
    }

    return Pair(newTail, prev)
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val l3 = ListNode(6)
    val l0 = ListNode(5)
    l0.next = l3
    val l5 = ListNode(4)
    l5.next = l0
    val l6 = ListNode(3)
    l6.next = l5
    val l32 = ListNode(2)
    l32.next = l6
    val l2 = ListNode(1)
    l2.next = l32
//    val reverse = reverse(l2, null)
    var rev = reverseKGroup(l2, 2)
    while (rev != null) {
        print(rev.`val`)
        rev = rev.next
    }
}