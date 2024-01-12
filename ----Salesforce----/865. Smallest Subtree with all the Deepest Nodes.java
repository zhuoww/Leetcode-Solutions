/*
 * medium
 * time: O(n), where n is the number of nodes in the binary tree
 * space: O(n), Recursive calls use the system stack, and the space complexity depends on the depth of the recursion
 * In the worst case, for a skewed binary tree, the recursion depth is n, resulting in a space complexity of O(n)
 * In the average case, where the recursion depth is the height of the tree, the space complexity is O(log n)
 * 
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (left > right) {
            return subtreeWithAllDeepest(root.left);
        } else if (left < right) {
            return subtreeWithAllDeepest(root.right);
        } else {
            return root;
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return -1;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
