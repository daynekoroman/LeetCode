package algo

class SnapshotArray(length: Int) {

    val d = HashMap<Int, HashMap<Int, Int>>()

    var snap: Int = 0

    fun set(index: Int, `val`: Int) {
        if (!d.containsKey(index)) d.put(index, HashMap())
        d[index]!![snap] = `val`
    }

    fun snap(): Int {
        return snap++
    }

    fun get(index: Int, snap_id: Int): Int {
        if (!d.containsKey(index)) return 0
        val max = d[index]!!.keys.filter { k -> k <= snap_id }.max()
        if (max == null) return 0
        return d[index]!![max!!] ?: 0
    }

}

fun main() {
    val snapshotArray = SnapshotArray(3)
    snapshotArray.set(0, 1)
    snapshotArray.snap()
    snapshotArray.set(0, 2)
    println(snapshotArray.get(0, 0))
    println(snapshotArray.get(0, 1))
}