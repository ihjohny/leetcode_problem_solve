package sort_an_array

class Solution {
    fun sortArray(nums: IntArray): IntArray {
        val size: Int = nums.size
        for (i in size / 2 - 1 downTo 0) heapify(nums, size, i)
        for (i in size - 1 downTo 1) {
            val temp: Int = nums[0]
            nums[0] = nums[i]
            nums[i] = temp
            heapify(nums, i, 0)
        }
        return nums
    }

    private fun heapify(arr: IntArray, size: Int, i: Int) {
        var largest = i
        val l = 2 * i + 1
        val r = 2 * i + 2
        if (l < size && arr[l] > arr[largest]) largest = l
        if (r < size && arr[r] > arr[largest]) largest = r
        if (largest != i) {
            val swap = arr[i]
            arr[i] = arr[largest]
            arr[largest] = swap
            heapify(arr, size, largest)
        }
    }
}
