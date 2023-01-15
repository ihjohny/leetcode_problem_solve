package add_two_numbers


class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return add(l1, l2, 0)
    }

    private fun add(one: ListNode?, two: ListNode?, cary: Int): ListNode? {
        if (one == null && two == null && cary == 0) {
            return null
        }

        val sum = (one?.`val` ?: 0) + (two?.`val` ?: 0) + cary

        return ListNode(
            (sum % 10)
        ).apply {
            next = add(one?.next, two?.next, (sum / 10))
        }
    }

}
