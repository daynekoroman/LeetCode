class MyHashSet() {

    private var values: Array<ArrayList<Int>> = Array(2) { i -> ArrayList<Int>() }
    private var cap = 0

    fun add(key: Int) {
        if (contains(key)) return
        values[key % values.size].add(key)
        cap++
        if (cap > values.size / 2) {
            val t: Array<ArrayList<Int>> = Array(values.size * 2) { i -> ArrayList<Int>() }
            values.forEach { l -> l.forEach { el -> t[el % t.size].add(el) } }
            values = t
        }
    }

    fun remove(key: Int) {
        if (contains(key)) cap --
        values[key % values.size].remove(key)
    }

    fun contains(key: Int): Boolean {
        return values[key % values.size].contains(key)
    }

}

fun main() {
    val myHashSet = MyHashSet()
    myHashSet.add(1)
    println(myHashSet.contains(1))
    println(myHashSet.contains(2))
    myHashSet.add(2)
    myHashSet.add(3)
    println(myHashSet.contains(2))
    println(myHashSet.contains(3))
    println(myHashSet.contains(1))

}