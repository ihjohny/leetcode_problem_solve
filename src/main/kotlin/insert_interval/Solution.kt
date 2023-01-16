package insert_interval

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val resultIntervals = ArrayList<IntArray>()

        var start: Int = Int.MAX_VALUE
        var end: Int = -1
        var position = -1

        for ((index, pair) in intervals.withIndex()) {
            if ((newInterval[0] > pair[1]) || (newInterval[1] < pair[0])) {

                // insert first
                if (index == 0) {
                    if (newInterval[1] < pair[0]) {
                        resultIntervals.add(intArrayOf(newInterval[0], newInterval[1]))
                    }
                }

                resultIntervals.add(pair)
                // insert into
                if (newInterval[0] > pair[1] && (index < intervals.lastIndex) && newInterval[1] < intervals[index + 1][0]) {
                    resultIntervals.add(intArrayOf(newInterval[0], newInterval[1]))
                }

                // insert last
                if (index == intervals.lastIndex) {
                    if (newInterval[0] > pair[1]) {
                        resultIntervals.add(intArrayOf(newInterval[0], newInterval[1]))
                    }
                }

            } else {
                if (position == -1) {
                    position = index
                }
                start = min(start, min(pair[0], newInterval[0]))
                end = max(end, max(pair[1], newInterval[1]))
            }
        }

        if (position != -1) {
            resultIntervals.add(position, intArrayOf(start, end))
        }

        if (resultIntervals.isEmpty()) {
            resultIntervals.add(newInterval)
        }

        return resultIntervals.toTypedArray()
    }
}
