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
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }

    public boolean dfs(TreeNode root) {
        if (root == null)
            return true;

        boolean left = dfs(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        } else {
            pre = root;
        }
        boolean right = dfs(root.right);

        return left && right;
    }
}