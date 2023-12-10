/*
 * medium
 * 要求一个节点 偷与不偷的两个状态所得到的金钱，那么返回值就是一个长度为2的数组
 * dp[i]: 下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱
 * 初始化： 在遍历的过程中，如果遇到空节点的话，很明显，无论偷还是不偷都是0，所以就返回
 * 遍历顺序： 后序遍历；因为要通过递归函数的返回值来做下一步计算
 * 递归： 通过递归左节点，得到左节点偷与不偷的金钱； 通过递归右节点，得到右节点偷与不偷的金钱
 * 如果是偷当前节点，那么左右孩子就不能偷： dp[1] = root.val + left[0] + right[0]
 * 如果不偷当前节点，那么左右孩子就可以偷，至于到底偷不偷一定是选一个最大的: dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
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
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;

        int[] dp = compare(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] compare(TreeNode root) {
        int[] dp = new int[2];
        if (root == null)
            return dp;

        int[] left = compare(root.left);
        int[] right = compare(root.right);

        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];

        return dp;
    }
}