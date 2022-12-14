package calculate_money_in_leetcode_bank

class Solution {
    fun totalMoney(n: Int): Int {
        var sum = 0
        var pre = 0
        for (i in 0 until n) {
            if ((i % 7) == 0) {
                pre++
            }
            sum += (i % 7) + pre
        }
        return sum
    }
}
