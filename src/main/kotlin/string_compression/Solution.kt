package string_compression

class Solution {
    fun compress(chars: CharArray): Int {
        var result = 0
        var lastLocalCount = 1
        var writePointer = 0
        for (i in 0 until (chars.size - 1)) {
            if (chars[i] == chars[i + 1]) {
                lastLocalCount++
            } else {
                result += if (lastLocalCount > 1) {
                    val slice = lastLocalCount.toString()
                    chars[writePointer++] = chars[i]
                    slice.forEach {
                        chars[writePointer++] = it
                    }
                    slice.length + 1
                } else {
                    chars[writePointer++] = chars[i]
                    1
                }
                lastLocalCount = 1
            }
        }
        result += if (lastLocalCount > 1) {
            val slice = lastLocalCount.toString()
            chars[writePointer++] = chars.last()
            slice.forEach {
                chars[writePointer++] = it
            }
            slice.length + 1
        } else {
            chars[writePointer++] = chars.last()
            1
        }
        return result
    }
}
