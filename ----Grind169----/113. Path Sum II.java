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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        if (root == null)
            return res;

        dfs(root, targetSum, res, path);
        return res;
    }

    public void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            res.add(new ArrayList(path));
        }

        if (root.left != null) {
            dfs(root.left, targetSum - root.val, res, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            dfs(root.right, targetSum - root.val, res, path);
            path.remove(path.size() - 1);
        }

    }
}
