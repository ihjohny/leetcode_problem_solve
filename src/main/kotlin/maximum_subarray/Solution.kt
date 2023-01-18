package maximum_subarray

import kotlin.math.max

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var currentSum = nums[0]
        var globalSum = nums[0]
        repeat(nums.size - 1) {
            currentSum = max(currentSum + nums[it + 1], nums[it + 1])
            globalSum = max(globalSum, currentSum)
        }
        return globalSum
    }
}
