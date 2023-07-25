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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode traversal(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd)
            return null;

        int index = map.get(postorder[postEnd - 1]);
        TreeNode root = new TreeNode(inorder[index]);

        int leftLen = index - inBegin;

        root.left = traversal(inorder, inBegin, index, postorder, postBegin, postBegin + leftLen);
        root.right = traversal(inorder, index + 1, inEnd, postorder, postBegin + leftLen, postEnd - 1);

        return root;

    }
}
