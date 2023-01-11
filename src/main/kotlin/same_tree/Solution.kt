class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }
        if (p?.value != q?.value) {
            return false
        }
        val left = isSameTree(p?.left, q?.left)
        val right = isSameTree(p?.right, q?.right)
        return (left && right)
    }
}

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
