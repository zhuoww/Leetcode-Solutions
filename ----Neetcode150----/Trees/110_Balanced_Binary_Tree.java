package Trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        // time: O(n)
        return traversal(root) != -1;
    }

    // calculate the height of a current subtree using recursion
    public int traversal(TreeNode root) {
        // base case
        if (root == null)
            return 0;

        int left = traversal(root.left); // height of left subtree
        if (left == -1)
            return -1; // in case of left subtree unbalanced
        int right = traversal(root.right); // height of right subtree
        if (right == -1)
            return -1; // in case of right subtree unbalanced

        if (Math.abs(left - right) > 1)
            return -1; // unbalanced

        return Math.max(left, right) + 1; // return the height of this subtree
    }

}