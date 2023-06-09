fun maxProfit(prices: IntArray, fee: Int): Int {
    var buy = -prices[0] - fee
    var sell = 0
    for (i in 1 until prices.size) {
        val tb = buy
        buy = maxOf(buy, sell - prices[i] - fee)
        sell = maxOf(tb + prices[i], sell)
    }
    return sell
}

fun main() {
    maxProfit(intArrayOf(1, 3, 2, 8, 4, 9), 2)
}