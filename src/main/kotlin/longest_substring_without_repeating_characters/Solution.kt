package longest_substring_without_repeating_characters

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        val hashMap: LinkedHashMap<Char, Int?> = LinkedHashMap()
        var count = 0
        s.forEachIndexed { index, c ->
            if (hashMap[c] == null) {
                hashMap[c] = index
                count++
            } else {
                maxLength = max(count, maxLength)
                count = index - hashMap[c]!!
                run loop@{
                    mutableSetOf<Char>().apply {
                        addAll(hashMap.keys)
                    }.forEach {
                        hashMap.remove(it)
                        if (it == c) {
                            return@loop
                        }
                    }
                }
                hashMap[c] = index
            }
        }
        return max(count, maxLength)
    }

    private fun max(a: Int, b: Int): Int {
        return if (a >= b) a else b
    }
}
