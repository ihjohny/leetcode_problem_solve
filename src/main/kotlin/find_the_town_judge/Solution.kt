package find_the_town_judge

class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val people = BooleanArray(n) { false }
        val validate = BooleanArray(n) { false }
        trust.forEach {
            people[it[0] - 1] = true
        }
        var ans = people.indexOfFirst { !it }
        if (ans != -1) {
            ans += 1
        } else {
            return -1
        }

        trust.forEach {
            if (!validate[it[0] - 1] && it[1] == ans) {
                validate[it[0] - 1] = true
            }
        }

        var nans = ans
        for (b in validate.withIndex()) {
            if (!b.value && (b.index+1) != ans) {
                nans = -1
                break
            }
        }
        return  nans
    }
}
