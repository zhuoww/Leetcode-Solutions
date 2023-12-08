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

/*
 * easy
 * time: O(n)->n is the number of nodes in the binary tree
 * space:O(n)->is determined by the maximum depth of the recursion stack
 */
class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        dfs(root, sb);
        return sb.toString();
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            sb.append(root.val);
            return;
        }

        sb.append(root.val);

        // dfs left tree
        sb.append('(');
        dfs(root.left, sb);
        sb.append(')');

        // dfs right tree
        if (root.right != null) {
            sb.append('(');
            dfs(root.right, sb);
            sb.append(')');
        }
    }
}
