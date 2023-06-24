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
    // time: O(n)
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return res;
    }

    // recursively calculates the height of the left and right subtrees
    public int height(TreeNode root) {
        if (root == null)
            return -1;// return -1 for an empty subtree, the traversal method ensures
                      // that when calculating the height of a parent node,
                      // the height of its child subtree is correctly considered as 0

        // post order traversal
        int left = height(root.left);
        int right = height(root.right);
        res = Math.max(res, (left + right + 2)); // max diameter, (left + right + 2):to account for the edges connecting
                                                 // the nodes

        return 1 + Math.max(left, right);// the height of the left and right subtrees

    }
}