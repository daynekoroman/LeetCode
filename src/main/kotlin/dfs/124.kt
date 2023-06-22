package dfs

fun maxPathSum(root: TreeNode?): Int {
    val dfs = dfs(root!!)
    return maxOf(dfs.first, dfs.second)
}

fun dfs(n: TreeNode): Pair<Int, Int> {
    var max = n.`val`
    var maxThrough = n.`val`
    if (n.left != null && n.right != null) {
        val l = dfs(n.left!!)
        val r = dfs(n.right!!)
        max = maxOf(max, n.`val` + l.second + r.second)
        max = maxOf(max, n.`val` + l.second)
        max = maxOf(max, n.`val` + r.second)
        max = maxOf(max, l.first)
        max = maxOf(max, r.first)
        maxThrough = maxOf(maxThrough, n.`val` + l.second)
        maxThrough = maxOf(maxThrough, n.`val` + r.second)
    } else {
        if (n.left != null) {
            val l = dfs(n.left!!)
            max = maxOf(max, max + l.second)
            max = maxOf(max, l.first)
            maxThrough = maxOf(maxThrough, n.`val` + l.second)
        }
        if (n.right != null) {
            val l = dfs(n.right!!)
            max = maxOf(max, max + l.second)
            max = maxOf(max, l.first)
            maxThrough = maxOf(maxThrough, n.`val` + l.second)
        }
    }

    return Pair(max, maxThrough)
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    //1,-2,-3,1,3,-2,null,-1
    val root = TreeNode(1)
    root.left = TreeNode(-2)
    root.right = TreeNode(-3)
    root.left?.left = TreeNode(1)
    root.left?.left?.left = TreeNode(-1)
    root.left?.right = TreeNode(3)
    root.right?.left = TreeNode(-2)

    println(maxPathSum(root))
}