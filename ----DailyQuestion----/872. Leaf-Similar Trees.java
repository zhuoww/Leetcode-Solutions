/*
 * easy
 * time:O(N), where N is the total number of nodes in the larger of the two trees.
 * space:O(N), In the worst case, where all nodes in both trees are leaf nodes, the vectors will store N/2 leaf values for each tree.
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(root1, list1);
        dfs(root2, list2);

        return list1.equals(list2);
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        dfs(root.left, list);
        dfs(root.right, list);

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
    }
}