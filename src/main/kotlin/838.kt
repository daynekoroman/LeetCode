fun pushDominoes(dominoes: String): String {
    var prev = HashMap<Int, Char>()
    var next = HashMap<Int, Char>()
    val state = dominoes.toCharArray()
    for(i in 0 until state.size) {
        change(i, state, prev)
    }

    while (prev.isNotEmpty()) {
        next = HashMap<Int, Char>()
        prev.forEach{ (i, c) -> state[i] = c}
        prev.keys.forEach{ i -> change(i, state, next)}
        prev = next;
    }

    return String(state)
}

fun change(i: Int, state: CharArray, acc: HashMap<Int, Char>) {
    if (state[i] == 'R' && i < state.size - 1 && state[i + 1] == '.' && (i + 2 == state.size || state[i + 2] != 'L'))
        acc.put(i + 1, 'R')
    if (state[i] == 'L' && i > 0 && state[i - 1] == '.' && (i == 1 || state[i - 2] != 'R'))
        acc.put(i - 1, 'L')
}

fun main(args: Array<String>) {
    println(pushDominoes(".L.R...LR..L.."))
}