package find_the_index_of_the_first_occurrence_in_a_string

class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (haystack.length < needle.length) return -1
        for (i in haystack.indices) {
            var pointer = i
            for (j in needle.indices) {
                if (haystack.getOrNull(pointer) == needle[j]) {
                    pointer++
                } else {
                    break
                }
            }
            if (pointer - i == needle.length) {
                return i
                break
            }
        }
        return -1
    }
}