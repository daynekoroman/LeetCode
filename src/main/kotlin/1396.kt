class UndergroundSystem() {

    val checkInStation: HashMap<Int, String> = HashMap()
    val checkInTime: HashMap<Int, Int> = HashMap()
    val sum: HashMap<String, Int> = HashMap()
    val count: HashMap<String, Int> = HashMap()

    fun checkIn(id: Int, stationName: String, t: Int) {
        checkInStation[id] = stationName
        checkInTime[id] = t
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val key = checkInStation[id]  + "_" + stationName
        val time = t - (checkInTime[id] ?: 0)
        sum[key] = time + (sum[key] ?: 0)
        count[key] = 1 + (count[key] ?: 0)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val key = startStation + "_" + endStation
        return sum[key]!!.toDouble() / count[key]!!
    }

}

fun main() {
    val undergroundSystem = UndergroundSystem()
    undergroundSystem.checkIn(45,"a",3)
    undergroundSystem.checkIn(32,"aa",8)
    undergroundSystem.checkIn(27,"a",10)
    undergroundSystem.checkOut(45,"ab",15)
    undergroundSystem.checkOut(27,"ab",20)
    undergroundSystem.checkOut(32,"b",22)
   println( undergroundSystem.getAverageTime("aa","b"))
   println( undergroundSystem.getAverageTime("a","ab"))
    undergroundSystem.checkIn(10,"a",24)
    undergroundSystem.getAverageTime("a","ab")
    undergroundSystem.checkOut(10,"ab",38)
    undergroundSystem.getAverageTime("a","ab")
}