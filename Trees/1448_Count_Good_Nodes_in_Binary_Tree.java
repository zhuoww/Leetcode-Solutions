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
    public int goodNodes(TreeNode root) {
        // DFS
        // preorder traversal
        // time: O(n)
        return traversal(root, Integer.MIN_VALUE);

    }

    // returns the number of good nodes in the subtree rooted at root
    public int traversal(TreeNode root, int max) {
        if (root == null)
            return 0;

        int count = root.val >= max ? 1 : 0;
        max = Math.max(max, root.val); // update the max value

        count += traversal(root.left, max);
        count += traversal(root.right, max);

        return count;
    }
}
