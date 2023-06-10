package binsearch

fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    var l = 0;
    var r = letters.size - 1;
    while (l <= r) {
        val c = l + (r - l) / 2;
        if (letters[c] > target) {
            r = c - 1;
        } else {
            l = c + 1;
        }
    }
    return letters[l % letters.size];
}

fun main() {
    println(nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'c'))
}