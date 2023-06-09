fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
    val a = coordinates[1][1] - coordinates[0][1]
    val b = coordinates[0][0] - coordinates[1][0]
    val c = -a * (coordinates[0][0]) - b * coordinates[0][1]

    return coordinates.all { p -> a * p[0] + b * p[1] + c == 0 }
}