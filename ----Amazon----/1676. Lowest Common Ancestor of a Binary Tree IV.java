/*
 * medium
 * time:O(n);space:O(n);
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<TreeNode> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node);
        }

        return dfs(root, set);
    }

    public TreeNode dfs(TreeNode root, HashSet<TreeNode> set) {
        if (root == null)
            return null;
        if (set.contains(root))
            return root;

        TreeNode left = dfs(root.left, set);
        TreeNode right = dfs(root.right, set);

        if (left != null && right != null) {
            return root;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return null;
        }
    }
}