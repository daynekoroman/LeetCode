package algo

import java.util.*

fun calculate(s: String): Int {
    var ss = s.replace(" ", "")
    val st = Stack<String>()
    if (ss.startsWith('-')) st.push("0")
    ss = ss.replace("(-", "(0-")
    for (c in ss) {
        when (c) {
            '(', '+', '-' -> st.push(c.toString())
            ')' -> eval(st)
            else -> {
                if (st.size == 0)
                    st.push(c.toString())
                else
                    when (st.peek()) {
                        "(", "+", "-" -> st.push(c.toString())
                        else -> {
                            st.push(st.pop() + c)
                        }
                    }
            }
        }
//        eval(st)
    }
    eval(st)
    return st.pop().toInt()
}

fun eval(s: Stack<String>) {
    var sum = 0
    var o = false
    while (s.size > 1) {
        val ar2 = s.pop()
        val op = s.pop()
        when (op) {
            "-" -> sum -= ar2.toInt()
            "+" -> sum += ar2.toInt()
            "(" -> {
                s.push((ar2.toInt() + sum).toString())
                sum = 0
                o = true
            }
        }
        if (o) break
    }
    if (s.size > 0)
        sum += s.pop().toInt()
    s.push(sum.toString())
}

fun main() {
    println(calculate("2-4-(8+2-6+(8+4-(1)+8-10))"))
}