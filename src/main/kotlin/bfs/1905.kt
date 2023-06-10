package bfs

fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
    val marker1 = marker(grid1)
    val marker2 = marker(grid2)
    val map = HashMap<Int, HashSet<Int>>()
    for (i in grid2.indices)
        for(j in grid2[0].indices)
            if (marker2[i][j] != 0)
                map.getOrPut(marker2[i][j]) {HashSet()}.add(marker1[i][j])

    return map.values.filter { it.count() == 1 && !it.contains(0) } .count()
}

fun marker(grid: Array<IntArray>): Array<IntArray> {
    val visited = Array(grid.size) { IntArray(grid[0].size) }
    var col = 0
    for (i in grid.indices)
        for(j in grid[0].indices)
            if (visited[i][j] == 0 && grid[i][j] != 0) {
                col ++
                visited[i][j] = col
                val q = ArrayDeque<Pair<Int, Int>>()
                q.add(Pair(i,j))
                while(!q.isEmpty()) {
                    val el = q.removeFirst()
                    val x = el.first
                    val y = el.second
                    if (grid[x][y] == 0) {
                        visited[x][y] = 0
                        continue
                    }
                    if (x > 0 && visited[x - 1][y] == 0) {
                        q.add(Pair(x - 1, y))
                        visited[x - 1][y] = col
                    }
                    if (x < grid.size - 1 && visited[x + 1][y] == 0) {
                        q.add(Pair(x + 1, y))
                        visited[x + 1][y] = col
                    }
                    if (y > 0 && visited[x][y - 1] == 0) {
                        q.add(Pair(x, y - 1))
                        visited[x][y - 1] = col
                    }
                    if (y < grid[0].size - 1 && visited[x][y + 1] == 0) {
                        q.add(Pair(x, y + 1))
                        visited[x][y + 1] = col
                    }
                }
            }
    return visited
}

fun main() {
    val grid = arrayOf(
        intArrayOf(1, 0, 1, 0, 1),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 0, 1, 0, 1)
    )
    val grid2 = arrayOf(
    intArrayOf(0,0,0,0,0),
    intArrayOf(1,1,1,1,1),
    intArrayOf(0,1,0,1,0),
    intArrayOf(0,1,0,1,0),
    intArrayOf(1,0,0,0,1))
    println( countSubIslands(grid, grid2))
}