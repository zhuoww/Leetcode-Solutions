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

// -------
class Solution {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        return (int) dfs(root, (long) targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int dfs(TreeNode node, long targetSum) {
        if (node == null)
            return 0;
        count = node.val == targetSum ? 1 : 0;

        count += dfs(node.left, targetSum - node.val);
        count += dfs(node.right, targetSum - node.val);

        return count;
    }
}

// +++++++
class Solution {
    int count;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        dfs(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }

    public void dfs(TreeNode node, int targetSum, long curSum) {
        if (node == null)
            return;
        curSum += node.val;
        if (curSum == targetSum)
            count++;

        dfs(node.left, targetSum, curSum);
        dfs(node.right, targetSum, curSum);
    }
}