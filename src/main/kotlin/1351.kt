fun countNegatives(grid: Array<IntArray>): Int {
    var res = 0
    var r = grid.size - 1
    var c = 0

    while (r >= 0 && c < grid[0].size) {
        if (grid[r][c] < 0) {
            res += grid[0].size - c
            r -= 1
        } else
            c += 1
    }

    return res
}