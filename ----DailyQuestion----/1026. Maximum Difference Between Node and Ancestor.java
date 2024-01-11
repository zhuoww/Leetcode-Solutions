/*
 * medium
 * time: O(n), where n is the number of nodes in the Binary Tree
 * space: O(h), where h is the height of the tree. This complexity arises from
 * the call stack that holds the recursive calls during the search process
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
    int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, root.val, root.val);
        return res;
    }

    public void dfs(TreeNode root, int max, int min) {
        if (root == null)
            return;

        int temp = Math.max(Math.abs(root.val - max), Math.abs(root.val - min));
        res = Math.max(res, temp);

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        dfs(root.left, max, min);
        dfs(root.right, max, min);

    }
}