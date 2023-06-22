package dfs

import java.util.*

fun maxLevelSum(root: TreeNode?): Int {
    var max = Int.MIN_VALUE
    var q = LinkedList<TreeNode>()
    var ans = 1
    var i = 1
    q.add(root!!)
    while (q.size > 0) {
        val sum = q.sumOf { it.`val` }
        if (sum > max) {
            max = sum
            ans = i
        }
        val next = LinkedList<TreeNode>()
        q.forEach { n ->
            if (n.left != null) next.add(n.left!!)
            if (n.right != null) next.add(n.right!!)
        }
        q = next
        i++
    }
    return ans
}


fun main() {

}