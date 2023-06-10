package backtracking

val set = setOf('1', '2', '3', '4', '5', '6', '7', '8', '9')
fun solveSudoku(board: Array<CharArray>): Unit {
    solve(board)
}

fun solve(board: Array<CharArray>): Boolean {
    for (i in 0..8)
        for (j in 0..8) {
            if (board[i][j] != '.') continue
            for (c in set) {
                if (valid(board, i, j, c)) {
                    board[i][j] = c
                    if (solve(board)) return true
                    board[i][j] = '.'
                }
            }
            return false
        }
    return true
}

fun valid(board: Array<CharArray>, row: Int, col: Int, c: Char): Boolean {
    for (i in 0..8) {
        if (board[row][i] == c) return false
        if (board[i][col] == c) return false
        if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false
    }
    return true
}

fun main() {
    val input = arrayOf(
        charArrayOf('.', '.', '9', '7', '4', '8', '.', '.', '.'),
        charArrayOf('7', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '2', '.', '1', '.', '9', '.', '.', '.'),
        charArrayOf('.', '.', '7', '.', '.', '.', '2', '4', '.'),
        charArrayOf('.', '6', '4', '.', '1', '.', '5', '9', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '3', '.', '.'),
        charArrayOf('.', '.', '.', '8', '.', '3', '.', '2', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '6'),
        charArrayOf('.', '.', '.', '2', '7', '5', '9', '.', '.'),
    )
    val arrayOf = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
    )
    solveSudoku(input)
    for (i in 0..8) {
        for (j in 0..8) {
            print(input[i][j] + ",")
        }
        println()
    }
}

