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
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode dfs(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd)
            return null;

        int index = map.get(preorder[preBegin]);
        TreeNode root = new TreeNode(inorder[index]);

        int leftLen = index - inBegin;

        root.left = dfs(preorder, preBegin + 1, preBegin + leftLen + 1, inorder, inBegin, index);
        root.right = dfs(preorder, preBegin + leftLen + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
