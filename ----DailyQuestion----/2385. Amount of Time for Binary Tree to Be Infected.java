/*
 * medium
 * time:O(N), where N is the number of nodes in the binary tree. 
 * space:O(H), where H is the height of the binary tree. This is due to the recursive calls in the depth-first search (DFS) method. 
 * In the worst case, the recursion stack will have a maximum depth equal to the height of the tree. In a balanced binary tree, 
 * the height is log(N), where N is the number of nodes. In the worst case (skewed tree), the height could be N, making the space complexity O(N).
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

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return res;
    }

    public int dfs(TreeNode root, int start) {
        // leaf node
        if (root == null)
            return 0;

        // traveral---postorder
        int leftDepth = dfs(root.left, start);
        int rightDepth = dfs(root.right, start);

        // 1.meet the start node. 2. not meet the start node
        if (root.val == start) {
            // update res and return -1, means found the start point
            res = Math.max(leftDepth, rightDepth);
            return -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            // return the depth
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            res = Math.max(res, Math.abs(leftDepth - rightDepth));
        }

        return Math.min(leftDepth, rightDepth) - 1;
    }
}
