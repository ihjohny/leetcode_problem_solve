package koko_eating_bananas

class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var min = 1
        var max = piles.max() ?: 0
        while (min < max) {
            val mid = (max + min) / 2
            val sumHour = tryEating(piles, h, mid)
            if (sumHour > h) {
                min = mid + 1
            } else {
                max = mid
            }
        }
        return max
    }

    private fun tryEating(piles: IntArray, h: Int, k: Int): Int {
        var hour = 0
        for (pile in piles) {
            hour += pile / k
            hour += (if ((pile % k) != 0) 1 else 0)
        }
        return hour
    }
}
