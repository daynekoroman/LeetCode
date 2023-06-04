import java.util.LinkedList

fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
    val emp: HashMap<Int, ArrayList<Int>> = HashMap()
    var max = 0
    for (i in manager.indices) {
        max = Math.max(max, dfs(emp, informTime, headID))
    }
    return dfs(emp, informTime, headID)
}

fun dfs(emp: HashMap<Int, ArrayList<Int>>, informTime: IntArray, m: Int): Int {
    val max = emp[m]?.map { empl -> if (emp.containsKey(empl)) dfs(emp, informTime, empl) else 0 }?.max()
    return informTime[m] + (max ?: 0)
}

fun main() {
    println(numOfMinutes(6, 2, intArrayOf(2, 2, -1, 2, 2, 2), intArrayOf(0, 0, 1, 0, 0, 0)))
}