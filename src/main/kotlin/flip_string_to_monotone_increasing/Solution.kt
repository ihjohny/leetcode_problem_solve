package flip_string_to_monotone_increasing

import kotlin.math.min

class Solution {
    fun minFlipsMonoIncr(s: String): Int {

        val zeroCount = s.filter { it == '0' }.length
        val oneCount = s.filter { it == '1' }.length
        var zero = zeroCount
        var one = 0
        var minimum = Int.MAX_VALUE

        s.forEach {
            if (it == '0') {
                zero--
            } else {
                one++
            }
            minimum = min(minimum, (zero + one))
        }

        minimum = min(minimum, zeroCount)
        minimum = min(minimum, oneCount)

        return minimum
    }
}
