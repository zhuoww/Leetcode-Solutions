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

// dfs
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null && rightNode != null) {
            return false;
        } else if (leftNode != null && rightNode == null) {
            return false;
        } else if (leftNode.val != rightNode.val) {
            return false;
        }

        boolean left = dfs(leftNode.left, rightNode.right);
        boolean right = dfs(rightNode.left, leftNode.right);

        return left && right;
    }

}

    // bfs
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> que = new LinkedList<>();

    if (root == null) return true;
    que.offer(root.left);
    que.offer(root.right);

    while (!que.isEmpty()){
        TreeNode leftNode = que.poll();
        TreeNode rightNode = que.poll();

        if (leftNode == null && rightNode == null) continue;
        if (leftNode != null && rightNode == null) return false;
        if (leftNode == null && rightNode != null) return false;
        if (leftNode.val != rightNode.val) return false;

        que.offer(leftNode.left);
        que.offer(rightNode.right);
        que.offer(leftNode.right);
        que.offer(rightNode.left);
    }
    return true;

}
