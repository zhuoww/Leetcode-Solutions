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
    private boolean res = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return res;
    }

    // height of current subtree
    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);// height of left subtree
        int right = dfs(root.right);// height of right subtree

        if (Math.abs(left - right) > 1) {// unbalanced
            res = false;
        }

        return Math.max(left, right) + 1;// return the height of this subtree
    }

}
