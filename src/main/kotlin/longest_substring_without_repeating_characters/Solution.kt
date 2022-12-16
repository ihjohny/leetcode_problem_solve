package longest_substring_without_repeating_characters

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        s.forEachIndexed { index, c ->
            val hashMap: LinkedHashMap<Char, Boolean> = LinkedHashMap()
            var iterationCount = 1
            for (i in (index + 1) until s.length) {
                if (s[i] == c || hashMap[s[i]] == true) {
                    break
                }
                hashMap[s[i]] = true
                iterationCount++
            }
            if (iterationCount > maxLength) {
                maxLength = iterationCount
            }
        }
        return maxLength
    }
}
